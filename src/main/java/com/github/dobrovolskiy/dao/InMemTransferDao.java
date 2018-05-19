package com.github.dobrovolskiy.dao;

import com.github.dobrovolskiy.model.Transfer;
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
public class InMemTransferDao implements TransferDao {
    private static final Logger log = LoggerFactory.getLogger(InMemTransferDao.class);
    private static final IdGenerator idGenerator = new NumberIdGenerator();
    private static final Map<String, Transfer> storage = new LinkedHashMap<>();

    @Override

    public List<Transfer> getAll() {
        return storage.values().stream().map(Transfer::new).collect(Collectors.toList());
    }

    @Override
    public Transfer get(String id) {
        Transfer transfer = storage.get(id);
        return transfer == null ? null : new Transfer(transfer);
    }

    @Override
    public Transfer save(Transfer transfer) {
        if (transfer.getId() == null) {
            transfer.setId(idGenerator.generateId());
        }
        storage.put(transfer.getId(), transfer);
        log.debug("Transfer {} saved ", transfer);
        return new Transfer(transfer);
    }

    @Override
    public boolean delete(String id) {
        Transfer removed = storage.remove(id);
        log.debug("Transfer {} removed ", removed);
        return removed != null;
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }
}
