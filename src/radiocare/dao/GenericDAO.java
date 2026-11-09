package radiocare.dao;

import java.util.List;

/**
 * Generic persistence contract: CRUD on one entity type.
 *
 * @param <T>  entity type
 * @param <ID> type of the entity's identifier
 */
public interface GenericDAO<T, ID> {

    /** Adds a new entity and persists it. */
    void save(T entity);

    /** @return the entity with this ID, or {@code null} if none exists */
    T findById(ID id);

    /** @return all entities (never {@code null}) */
    List<T> findAll();

    /** Replaces the stored entity that has the same ID and persists the change. */
    void update(T entity);

    /** Removes the entity with this ID and persists the change. */
    void delete(ID id);

    /** @return {@code true} if an entity with this ID exists */
    boolean existsById(ID id);
}