package com.github.dobrovolskiy.validator;

import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Account;

import java.math.BigDecimal;

/**
 * Account validator
 * <p>
 * Checks: not null, balance > 0
 *
 * @see Validator
 * @see Account
 * @since 1.0
 */
public class AccountValidator implements Validator<Account> {
    @Override
    public void validate(Account account) throws BusinessException {
        if (account != null) {
            if (BigDecimal.ZERO.compareTo(account.getBalance()) == 1) {
                throw new BusinessException("Invalid account balance");
            }
        } else throw new BusinessException("Account does not exist");
    }
}
