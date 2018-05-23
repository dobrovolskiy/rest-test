package com.github.dobrovolskiy.controller;

/**
 * POJO for paging request
 *
 * @since 1.0
 */
public class PageRequest {
    public final Integer page;
    public final Integer size;

    public PageRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
