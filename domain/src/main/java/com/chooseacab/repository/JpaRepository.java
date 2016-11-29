package com.chooseacab.repository;

import java.util.Collection;

/*
 * Common JPA repository.
 */
public interface JpaRepository<T>
{
    /**
     * <p>
     * Finds the entity of type T with the given primary key id.
     * </p>
     *
     * @param id
     *            primary key object
     * @return entity of type T of the given id
     */
    T findById(Object id);

    /**
     * <p>
     * Persists the given entity. This operation should take care of create and updates for the
     * given entity and if configured, even cascade the changes to the associated entities.
     * </p>
     *
     * @param entity
     *            entity to be made persistent
     * @return persisted entity
     */
    T makePersist(T entity);
}
