package com.github.dobrovolskiy.validator;

import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Account;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created on 19.05.2018.
 */
public class AccountValidatorTest {

    private AccountValidator validator = new AccountValidator();

    @Test(expected = BusinessException.class)
    public void validateNull() throws Exception {
        validator.validate(null);
    }

    @Test(expected = BusinessException.class)
    public void validateNegativeBalance() throws Exception {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(-1));
        validator.validate(account);
    }

    @Test
    public void validateZero() throws Exception {
        Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        validator.validate(account);
    }

    @Test
    public void validate() throws Exception {
        Account account = new Account();
        account.setBalance(BigDecimal.ONE);
        validator.validate(account);
    }

}