package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.utils.PageUtil;

import java.util.List;

public interface RegistryOfficeService {

    void create(RegistryEntity registry);

    void update(RegistryEntity registry);

    void delete(Long id);

    List<RegistryEntity> findAll();

    RegistryEntity findById(Long id);

    List<RegistryEntity> findByName(String name);

    PageUtil<RegistryEntity> findAllWithPage(int page, int size);
}
