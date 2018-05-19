package com.github.dobrovolskiy.model.generator;

import java.util.UUID;

/**
 * Generates id based on {@link UUID}
 *
 * @see UUID
 * @since 1.0
 */
public class GuidIdGenerator implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
