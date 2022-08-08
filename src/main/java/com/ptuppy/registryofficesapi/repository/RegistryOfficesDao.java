package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.utils.PageUtil;

import java.util.List;

public interface RegistryOfficesDao {

    void save(RegistryEntity registry);

    List<RegistryEntity> findAll();

    RegistryEntity findById(Long id);

    List<RegistryEntity> findByName(String name);

    void update(RegistryEntity registry);

    void delete(Long id);

    PageUtil<RegistryEntity> findAllPaginated(int page, int size);

}
