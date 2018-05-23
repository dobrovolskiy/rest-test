package com.github.dobrovolskiy.controller;

import java.util.List;

/**
 * POJO for paging data
 *
 * @since 1.0
 */
public class PageResponse<T> {
    public final Integer page;
    public final Integer size;
    public final Integer total;
    public final List<T> data;

    public PageResponse(Integer page, Integer size, Integer total, List<T> response) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = response;
    }
}
