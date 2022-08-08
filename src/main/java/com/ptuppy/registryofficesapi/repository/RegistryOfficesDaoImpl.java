package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.utils.PageUtil;
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

    @Override
    public PageUtil<RegistryEntity> findAllPaginated(int page, int size) {
        int start = (page - 1) * size;
        List<RegistryEntity> list = getEntityManager().createQuery("select r from RegistryEntity r order by r.name asc",RegistryEntity.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();

        long total = count();
        long totalPages = (total + (size-1))/ size;

        return new PageUtil<RegistryEntity>(size,page,totalPages,list);
    }

    public long count() {
        return getEntityManager()
                .createQuery("select count(*) from RegistryEntity", Long.class)
                .getSingleResult();
    }
}
