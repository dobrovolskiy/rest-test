package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created on 19.05.2018.
 */
public class InMemTransferDaoTest {
    private InMemTransferDao transferDao = new InMemTransferDao();

    @Before
    public void init() {
        transferDao.deleteAll();
    }


    @Test
    public void getAll() {
        Transfer expected = new Transfer();
        transferDao.save(expected);
        List<Transfer> transfers = transferDao.getAll();
        Assert.assertEquals(1, transfers.size());
        Assert.assertEquals(expected, transfers.get(0));
    }

    @Test
    public void get() {
        String expectedId = "id";
        Transfer expected = new Transfer();
        expected.setId(expectedId);
        transferDao.save(expected);
        Transfer transfer = transferDao.get(expectedId);
        Assert.assertEquals(expected, transfer);
    }

    @Test
    public void save() {
        String expectedId = "id";
        Transfer expected = new Transfer();
        expected.setId(expectedId);
        Transfer saved = transferDao.save(expected);
        Assert.assertEquals(expected, saved);
    }

    @Test
    public void delete() {
        String expectedId = "id";
        Transfer expected = new Transfer();
        expected.setId(expectedId);
        transferDao.save(expected);
        boolean isDeleted = transferDao.delete(expectedId);
        Assert.assertTrue(isDeleted);
        Assert.assertNull(transferDao.get(expectedId));
    }

    @Test
    public void deleteNotExisted() {
        String expectedId = "id1";
        String deletedId = "id2";
        Transfer expected = new Transfer();
        expected.setId(expectedId);
        transferDao.save(expected);
        boolean isDeleted = transferDao.delete(deletedId);
        Assert.assertFalse(isDeleted);
        Assert.assertEquals(expected, transferDao.get(expectedId));
    }

}