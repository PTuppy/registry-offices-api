package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.repository.RegistryOfficesDao;
import com.ptuppy.registryofficesapi.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegistryOfficeServiceImpl implements RegistryOfficeService{

    @Autowired
    private RegistryOfficesDao dao;

    @Override
    public void create(RegistryEntity registry) {
        dao.save(registry);
    }

    @Override
    public void update(RegistryEntity registry) {
        dao.update(registry);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistryEntity> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RegistryEntity findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistryEntity> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public PageUtil<RegistryEntity> findAllWithPage(int page, int size) {
        return dao.findAllPaginated(page, size);
    }
}
