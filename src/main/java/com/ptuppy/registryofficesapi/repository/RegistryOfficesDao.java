package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;

import java.util.List;

public interface RegistryOfficesDao {

    void save(RegistryEntity registry);

    List<RegistryEntity> findAll();

    RegistryEntity findById(Long id);

    void update(RegistryEntity registry);

    void delete(Long id);

}
