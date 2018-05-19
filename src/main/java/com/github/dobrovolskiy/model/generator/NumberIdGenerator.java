package com.github.dobrovolskiy.model.generator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Generates id based on {@link Long} sequence
 *
 * @since 1.0
 */
public class NumberIdGenerator implements IdGenerator {
    private static AtomicLong idCounter = new AtomicLong();

    @Override
    public String generateId() {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
