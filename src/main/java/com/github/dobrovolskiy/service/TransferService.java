package com.github.dobrovolskiy.service;

import com.github.dobrovolskiy.model.Transfer;

import java.util.List;

/**
 * Service to perform transfer operations
 *
 * @see Transfer
 * @since 1.0
 */
public interface TransferService {
    List<Transfer> getAll();

    Transfer getById(String id);

    Transfer create(Transfer transfer);

    Transfer update(Transfer transfer);

    boolean delete(String id);

    void deleteAll();
}
