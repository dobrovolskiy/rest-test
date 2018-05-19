package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created on 19.05.2018.
 */
public class InMemAccountDaoTest {
    private InMemAccountDao accountDao = new InMemAccountDao();

    @Before
    public void setUp() throws Exception {
        accountDao.deleteAll();
    }

    @Test
    public void getAll() {
        Account expected = new Account();
        accountDao.save(expected);
        List<Account> accounts = accountDao.getAll();
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals(expected, accounts.get(0));
    }

    @Test
    public void get() {
        String expectedId = "id";
        Account expected = new Account();
        expected.setId(expectedId);
        accountDao.save(expected);
        Account account = accountDao.get(expectedId);
        Assert.assertEquals(expected, account);
    }

    @Test
    public void save() {
        String expectedId = "id";
        Account expected = new Account();
        expected.setId(expectedId);
        Account saved = accountDao.save(expected);
        Assert.assertEquals(expected, saved);
    }

    @Test
    public void delete() {
        String expectedId = "id";
        Account expected = new Account();
        expected.setId(expectedId);
        accountDao.save(expected);
        boolean isDeleted = accountDao.delete(expectedId);
        Assert.assertTrue(isDeleted);
        Assert.assertNull(accountDao.get(expectedId));
    }

    @Test
    public void deleteNotExisted() {
        String expectedId = "id1";
        String deletedId = "id2";
        Account expected = new Account();
        expected.setId(expectedId);
        accountDao.save(expected);
        boolean isDeleted = accountDao.delete(deletedId);
        Assert.assertFalse(isDeleted);
        Assert.assertEquals(expected, accountDao.get(expectedId));
    }

}