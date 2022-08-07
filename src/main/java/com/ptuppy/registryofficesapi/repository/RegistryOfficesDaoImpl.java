package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RegistryOfficesDaoImpl extends AbstractDao<RegistryEntity,Long> implements RegistryOfficesDao{


    @Override
    public List<RegistryEntity> findByName(String name) {
        return  getEntityManager().createQuery("select r from RegistryEntity r where r.name like :name",RegistryEntity.class)
                .setParameter("name", name)
                .getResultList();
    }
}
