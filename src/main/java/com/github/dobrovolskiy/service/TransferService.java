package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.controller.PageRequest;
import com.github.dobrovolskiy.controller.PageResponse;
import com.github.dobrovolskiy.model.Transfer;

/**
 * Service to perform transfer operations
 *
 * @see Transfer
 * @since 1.0
 */
public interface TransferService {
    PageResponse<Transfer> getAll(PageRequest pageRequest);

    Transfer getById(String id);

    Transfer create(Transfer transfer);

    Transfer update(Transfer transfer);

    boolean delete(String id);

    void deleteAll();
}
