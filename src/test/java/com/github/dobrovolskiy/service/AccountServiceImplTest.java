package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 19.05.2018.
 */
public class AccountServiceImplTest {

    private final AccountService service = new AccountServiceImpl();

    @Before
    public void setUp() throws Exception {
        service.deleteAll();
    }

    @Test
    public void getAll() throws Exception {
        List<Account> accounts = service.getAll();
        Assert.assertEquals(0, accounts.size());
    }

    @Test
    public void getById() throws Exception {
        Account account = service.getById("id1");
        Assert.assertNull(account);
    }

    @Test
    public void exists() throws Exception {
        Account expected = service.create(createAccount(null, BigDecimal.ZERO));
        Assert.assertTrue(service.exists(expected.getId()));
    }

    @Test
    public void existsFalse() throws Exception {
        Assert.assertFalse(service.exists("id1"));
    }

    @Test
    public void create() throws Exception {
        Account expected = createAccount(null, BigDecimal.ZERO);
        Account actual = service.create(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        Account account = createAccount(null, BigDecimal.ZERO);
        Account expected = service.create(account);
        expected.setBalance(BigDecimal.ONE);
        Account updated = service.update(expected);
        Assert.assertEquals(expected, updated);
    }

    @Test
    public void delete() throws Exception {
        Account actual = service.create(createAccount(null, BigDecimal.ZERO));
        Assert.assertTrue(service.delete(actual.getId()));
    }

    @Test
    public void deleteNotExisted() throws Exception {
        Assert.assertFalse(service.delete("notExistedId"));
    }

    private Account createAccount(String id1, BigDecimal balance) {
        Account account = new Account();
        account.setId(id1);
        account.setBalance(balance);
        return account;
    }
}