package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.controller.PageRequest;
import com.github.dobrovolskiy.controller.PageResponse;
import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created on 19.05.2018.
 */
public class TransferServiceImplTest {
    private final TransferService service = new TransferServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();

    @Before
    public void setUp() {
        service.deleteAll();
    }

    @Test
    public void getAll() {
        PageResponse<Transfer> transfers = service.getAll(new PageRequest(0, 10));
        Assert.assertEquals(0, transfers.data.size());
    }

    @Test
    public void getById() {
        Transfer notExist = service.getById("id1");
        Assert.assertNull(notExist);
    }

    @Test
    public void create() {
        String srcAccountId = "accId1";
        String destAccountId = "accId2";
        BigDecimal amount = BigDecimal.ONE;
        createAccount(srcAccountId, amount);
        createAccount(destAccountId, amount);
        Transfer expected = createTransfer(null, srcAccountId, destAccountId, amount);

        Transfer created = service.create(expected);

        Assert.assertEquals(expected, created);
        Assert.assertEquals(BigDecimal.ZERO, accountService.getById(srcAccountId).getBalance());
        Assert.assertEquals(BigDecimal.valueOf(2), accountService.getById(destAccountId).getBalance());
    }

    @Test
    public void update() {
        String id = "id1";
        String srcAccountId = "accId1";
        String destAccountId = "accId2";
        BigDecimal amount = BigDecimal.valueOf(10);
        createAccount(srcAccountId, amount);
        createAccount(destAccountId, amount);
        Transfer expected = service.create(createTransfer(id, srcAccountId, destAccountId, amount));

        expected.setAmount(BigDecimal.ONE);

        Transfer updated = service.update(expected);

        Assert.assertEquals(expected, updated);
        Assert.assertEquals(BigDecimal.valueOf(9), accountService.getById(srcAccountId).getBalance());
        Assert.assertEquals(BigDecimal.valueOf(11), accountService.getById(destAccountId).getBalance());
    }

    @Test
    public void delete() {
        String srcAccountId = "accId1";
        String destAccountId = "accId2";
        BigDecimal amount = BigDecimal.valueOf(10);
        createAccount(srcAccountId, amount);
        createAccount(destAccountId, amount);
        Transfer created = service.create(createTransfer(null, srcAccountId, destAccountId, amount));

        Assert.assertTrue(service.delete(created.getId()));
        Assert.assertNull(service.getById(created.getId()));
        Assert.assertEquals(amount, accountService.getById(srcAccountId).getBalance());
        Assert.assertEquals(amount, accountService.getById(destAccountId).getBalance());
    }

    private Transfer createTransfer(String id, String srcAccount, String destAccount, BigDecimal amount) {
        Transfer result = new Transfer();
        result.setId(id);
        result.setSrcAccountId(srcAccount);
        result.setDestAccountId(destAccount);
        result.setAmount(amount);
        return result;
    }

    private Account createAccount(String id1, BigDecimal amount) {
        Account account = new Account();
        account.setId(id1);
        account.setBalance(amount);
        accountService.create(account);
        return account;
    }
}