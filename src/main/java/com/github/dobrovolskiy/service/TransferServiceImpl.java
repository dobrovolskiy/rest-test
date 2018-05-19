package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.dao.InMemTransferDao;
import com.github.dobrovolskiy.dao.TransferDao;
import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.model.Transfer;
import com.github.dobrovolskiy.validator.TransferValidator;

import java.math.BigDecimal;
import java.util.List;

/**
 * {@link TransferService} implementation with in-memory storage
 * <p>
 * Provides business operations with money transfers between accounts.
 * <p>
 * Uses {@link TransferValidator} for validation
 *
 * @see Transfer
 * @see InMemTransferDao
 * @see AccountServiceImpl
 * @see TransferValidator
 * @since 1.0
 */
public class TransferServiceImpl implements TransferService {

    private final TransferDao transferDao = new InMemTransferDao();
    private final AccountService accountService = new AccountServiceImpl();
    private final TransferValidator validator = new TransferValidator(accountService);

    @Override
    public List<Transfer> getAll() {
        return transferDao.getAll();
    }

    @Override
    public Transfer getById(String id) {
        return transferDao.get(id);
    }

    @Override
    public Transfer create(Transfer transfer) throws BusinessException {
        transfer.setId(null);
        validator.validate(transfer);
        provideTransfer(transfer);
        return transferDao.save(transfer);
    }

    @Override
    public Transfer update(Transfer transfer) throws BusinessException {
        validator.validate(transfer);
        Transfer old = transferDao.get(transfer.getId());
        cancelTransfer(old);
        try {
            provideTransfer(transfer);
        } catch (BusinessException e) {
            provideTransfer(old);
            throw e;
        }
        return transferDao.save(transfer);
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        Transfer transfer = transferDao.get(id);
        validator.validate(transfer);
        cancelTransfer(transfer);
        return transferDao.delete(id);
    }

    @Override
    public void deleteAll() {
        transferDao.deleteAll();
    }

    private void provideTransfer(Transfer transfer) {
        if (transfer != null) {
            Account srcAccount = accountService.getById(transfer.getSrcAccountId());
            Account desAccount = accountService.getById(transfer.getDestAccountId());
            BigDecimal transferAmount = transfer.getAmount();
            updateBalance(srcAccount, transferAmount.negate());
            accountService.update(srcAccount);
            updateBalance(desAccount, transferAmount);
            accountService.update(desAccount);
        }
    }

    private void cancelTransfer(Transfer transfer) {
        if (transfer != null) {
            Account srcAccount = accountService.getById(transfer.getSrcAccountId());
            Account desAccount = accountService.getById(transfer.getDestAccountId());
            BigDecimal transferAmount = transfer.getAmount();
            updateBalance(desAccount, transferAmount.negate());
            accountService.update(desAccount);
            updateBalance(srcAccount, transferAmount);
            accountService.update(srcAccount);
        }
    }

    private static void updateBalance(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
    }
}
