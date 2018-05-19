package com.github.dobrovolskiy.validator;

import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Transfer;
import com.github.dobrovolskiy.service.AccountService;

import java.math.BigDecimal;


/**
 * Transfer validator
 * <p>
 * Checks: not null, amount > 0
 *
 * @see Validator
 * @see Transfer
 * @since 1.0
 */
public class TransferValidator implements Validator<Transfer> {

    private AccountService accountService;

    public TransferValidator(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void validate(Transfer toValidate) throws BusinessException {
        if (toValidate != null) {
            if (BigDecimal.ZERO.compareTo(toValidate.getAmount()) == 1) {
                throw new BusinessException("Invalid transfer amount");
            } else if (!accountService.exists(toValidate.getSrcAccountId())) {
                throw new BusinessException("Transfer source account does not exist");
            } else if (!accountService.exists(toValidate.getDestAccountId())) {
                throw new BusinessException("Transfer destination account does not exist");
            } else if (toValidate.getSrcAccountId().equals(toValidate.getDestAccountId())) {
                throw new BusinessException("Source and destination accounts are equals");
            }
        } else throw new BusinessException("Transfer does not exist");
    }
}
