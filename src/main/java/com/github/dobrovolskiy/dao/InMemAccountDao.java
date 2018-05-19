package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.model.generator.GuidIdGenerator;
import com.github.dobrovolskiy.model.generator.IdGenerator;
import com.github.dobrovolskiy.model.generator.NumberIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation with in memory ({@link LinkedHashMap}) storage
 * <p>
 * Uses {@link GuidIdGenerator} for the new object Id
 *
 * @see GuidIdGenerator
 * @since 1.0
 */
public class InMemAccountDao implements AccountDao {
    private static final Logger log = LoggerFactory.getLogger(InMemTransferDao.class);
    private static final IdGenerator idGenerator = new NumberIdGenerator();
    private static final Map<String, Account> storage = new LinkedHashMap<>();

    @Override
    public List<Account> getAll() {
        return storage.values().stream().map(Account::new).collect(Collectors.toList());
    }

    @Override
    public boolean exists(String id) {
        return storage.containsKey(id);
    }

    @Override
    public Account get(String id) {
        Account account = storage.get(id);
        return account == null ? null : new Account(account);
    }

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(idGenerator.generateId());
        }
        storage.put(account.getId(), account);
        log.debug("Account {} saved ", account);
        return new Account(account);
    }

    @Override
    public boolean delete(String id) {
        Account removed = storage.remove(id);
        log.debug("Account {} removed ", removed);
        return removed != null;
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }
}
