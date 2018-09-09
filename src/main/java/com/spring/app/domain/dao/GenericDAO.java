package com.spring.app.domain.dao;

import com.spring.app.domain.BaseEntity;

import java.util.List;

/**
 * Provides base methods interface version for any entity.
 *
 * @param <T> - type of entity to persist
 * @author Evgenii Ray
 */
public interface GenericDAO<T extends BaseEntity> {

    /**
     * Finds entity by its id
     *
     * @param id - entity id
     * @return - entity with a passed id
     */
    T findById(final Long id);

    /**
     * Finds entity by its id and class name
     *
     * @param id              - entity id
     * @param persistentClass - persistent class
     * @return - entity with a passed id
     */
    BaseEntity findById(final Long id, Class<? extends BaseEntity> persistentClass);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Returns all instances of the type.
     *
     * @param persistentClass - persistent class
     * @return all entities
     */
    List<BaseEntity> findAll(Class<? extends BaseEntity> persistentClass);

    /**
     * Saves a given entity.
     *
     * @param entity must not be {@literal null}.
     */
    void create(final T entity);

    /**
     * Update entity which is passed to a method
     *
     * @param entity - entity to update
     */
    void update(final T entity);

    /**
     * Deletes a given entity.
     *
     * @param entity - entity to delete
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    void delete(final T entity);

    /**
     * Deletes the entity with the given id.
     *
     * @param entityId must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void deleteById(final long entityId);
}