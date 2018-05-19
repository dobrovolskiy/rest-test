package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.model.Account;

import java.util.List;

/**
 * Service to process {@link Account} operations
 *
 * @see Account
 * @since 1.0
 */
public interface AccountService {

    List<Account> getAll();

    Account getById(String id);

    boolean exists(String id);

    Account create(Account account);

    Account update(Account account);

    boolean delete(String id);

    void deleteAll();
}
