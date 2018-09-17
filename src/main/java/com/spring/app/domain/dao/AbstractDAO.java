package com.spring.app.domain.dao;

import com.spring.app.domain.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Provides Generic Abstract version of DAO for any entity.
 * Implements base methods for data accessing. Follows the method
 *
 * @param <T> - type of entity to persist
 */
@Transactional
public abstract class AbstractDAO<T extends BaseEntity> {

    private Class<T> persistentClass;

    protected EntityManager em;

    /**
     * Sets persistent class to the dao in order to provide
     * access to the entity
     *
     * @param persistentClass - type of entity
     */
    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * Finds entity by its id
     *
     * @param id - entity id
     * @return - entity with a passed id
     */
    public T findById(Long id) {
        return em.find(persistentClass, id);
    }

    /**
     * Finds entity by its id and type
     *
     * @param id - entity id
     * @return - entity with a passed id
     */
    public BaseEntity findById(Long id, Class<? extends BaseEntity> persistentClass) {
        return em.find(persistentClass, id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    public List<T> findAll() {
        return em.createQuery("from " + persistentClass.getName())
                .getResultList();
    }

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    public List<BaseEntity> findAll(Class<? extends BaseEntity> persistentClass) {
        return em.createQuery("from " + persistentClass.getName())
                .getResultList();
    }

    /**
     * Saves a given entity.
     *
     * @param entity must not be {@literal null}.
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     * Update entity which is passed to a method
     *
     * @param entity - entity to update
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * Deletes a given entity.
     *
     * @param entity - entity to delete
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    public void delete(T entity) {
        em.remove(entity);
    }


    /**
     * Deletes the entity with the given id.
     *
     * @param entityId must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    public void deleteById(long entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Flushes and clears em context
     */
    public void flushAndClear() {
        em.flush();
        em.clear();
    }

}
