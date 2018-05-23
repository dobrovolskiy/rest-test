package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.controller.PageRequest;
import com.github.dobrovolskiy.controller.PageResponse;
import com.github.dobrovolskiy.model.Transfer;

/**
 * CRUD dao for transfer operations
 *
 * @see Transfer
 * @since 1.0
 */
public interface TransferDao {
    PageResponse<Transfer> getAll(PageRequest pageRequest);

    Transfer get(String id);

    Transfer save(Transfer transfer);

    boolean delete(String id);

    void deleteAll();
}
