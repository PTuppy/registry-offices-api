package com.ptuppy.registryofficesapi.utils;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;

import java.util.List;

public class PageUtil<T> {

    private final Integer size;
    private final Integer page;
    private final Long totalPages;
    private final List<T> registry;

    public PageUtil(Integer size, Integer page, Long totalPages, List<T> registry) {
        this.size = size;
        this.page = page;
        this.totalPages = totalPages;
        this.registry = registry;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPage() {
        return page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public List<T> getRegistry() {
        return registry;
    }
}
