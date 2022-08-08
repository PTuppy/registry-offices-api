package com.ptuppy.registryofficesapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass =
            (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {

        entityManager.merge(entity);
    }

    public void delete(PK id) {

        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id) {

        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {

        return entityManager
                .createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

}
