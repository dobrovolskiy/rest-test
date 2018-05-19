package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Transfer;

import java.util.List;

/**
 * CRUD dao for transfer operations
 *
 * @see Transfer
 * @since 1.0
 */
public interface TransferDao {
    List<Transfer> getAll();

    Transfer get(String id);

    Transfer save(Transfer transfer);

    boolean delete(String id);

    void deleteAll();
}
