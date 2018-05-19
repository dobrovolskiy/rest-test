package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Account;

import java.util.List;

/**
 * CRUD dao for {@link Account}
 *
 * @see Account
 * @since 1.0
 */
public interface AccountDao {
    List<Account> getAll();

    boolean exists(String id);

    Account get(String id);

    Account save(Account account);

    boolean delete(String id);

    void deleteAll();
}
