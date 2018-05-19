package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.dao.AccountDao;
import com.github.dobrovolskiy.dao.InMemAccountDao;
import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.validator.AccountValidator;

import java.util.List;

/**
 * {@link AccountService} implementation with in-memory storage
 * <p>
 * Provides business operations with money transfers.
 *
 * @see Account
 * @see InMemAccountDao
 * @since 1.0
 */
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao = new InMemAccountDao();
    private final AccountValidator validator = new AccountValidator();

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public Account getById(String id) {
        return accountDao.get(id);
    }

    @Override
    public boolean exists(String id) {
        return accountDao.exists(id);
    }

    @Override
    public Account create(Account account) throws BusinessException {
        validator.validate(account);
        return accountDao.save(account);
    }

    @Override
    public Account update(Account account) throws BusinessException {
        validator.validate(account);
        return accountDao.save(account);
    }


    @Override
    public boolean delete(String id) {
        return accountDao.delete(id);
    }

    @Override
    public void deleteAll() {
        accountDao.deleteAll();
    }
}
