package com.github.dobrovolskiy.validator;

import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.model.Transfer;
import com.github.dobrovolskiy.service.AccountServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created on 19.05.2018.
 */
public class TransferValidatorTest {
    private final AccountServiceImpl accountService = new AccountServiceImpl();
    private final TransferValidator validator = new TransferValidator(accountService);

    @Test(expected = BusinessException.class)
    public void validateNull() throws Exception {
        validator.validate(null);
    }

    @Test(expected = BusinessException.class)
    public void validateNegativeBalance() throws Exception {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(-1));
        validator.validate(transfer);
    }

    @Test(expected = BusinessException.class)
    public void validateDestAccountNotExists() throws Exception {
        Transfer transfer = new Transfer();
        String srcAccountId = "id1";
        transfer.setSrcAccountId(srcAccountId);
        accountService.create(createAccount(srcAccountId));
        transfer.setAmount(BigDecimal.ONE);
        validator.validate(transfer);
    }

    @Test(expected = BusinessException.class)
    public void validateSrcAccountNotExists() throws Exception {
        Transfer transfer = new Transfer();
        String destAccountId = "id2";
        transfer.setDestAccountId(destAccountId);
        accountService.create(createAccount(destAccountId));
        transfer.setAmount(BigDecimal.ONE);
        validator.validate(transfer);
    }

    @Test
    public void validateZero() throws Exception {
        Transfer transfer = new Transfer();
        String srcAccountId = "id1";
        String destAccountId = "id2";
        transfer.setSrcAccountId(srcAccountId);
        transfer.setDestAccountId(destAccountId);
        accountService.create(createAccount(srcAccountId));
        accountService.create(createAccount(destAccountId));
        transfer.setAmount(BigDecimal.ZERO);
        validator.validate(transfer);
    }

    private Account createAccount(String id1) {
        Account account = new Account();
        account.setId(id1);
        account.setBalance(BigDecimal.ONE);
        return account;
    }

    @Test
    public void validate() throws Exception {
        Transfer transfer = new Transfer();
        String srcAccountId = "id1";
        String destAccountId = "id2";
        transfer.setSrcAccountId(srcAccountId);
        transfer.setDestAccountId(destAccountId);
        accountService.create(createAccount(srcAccountId));
        accountService.create(createAccount(destAccountId));
        transfer.setAmount(BigDecimal.ONE);
        validator.validate(transfer);
    }


}