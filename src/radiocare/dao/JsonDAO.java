package radiocare.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * DAO that keeps all entities in memory and persists them to one JSON file.
 * <p>
 * Loads the file once at construction, always returns the same in-memory
 * instances, and rewrites the file after every change.
 */
public class JsonDAO<T, ID> implements GenericDAO<T, ID> {

    /** In-memory store, keyed by ID. */
    private final Map<ID, T> store = new LinkedHashMap<>();

    /** Path of the JSON file, e.g. "data/patients.json". */
    private final String filePath;

    /** Entity class, needed by the JSON(Gson) library to rebuild objects.
     <p>
     Due to Java Type Erasure, generic types (<T>) are removed at compile time, leaving the JVM unaware of the target class at runtime.
     Passing the explicit class token (e.g.,@code Entity.class) provides Gson with the concrete runtime blueprint required.

      */
    private final Class<T> entityClass;

    /** A function that takes an entity and returns its ID, e.g. Patient::getCinMatricule.
     * The generic DAO can’t know which getter holds the ID for each entity,
     * so each subclass hands it over. */
    private final Function<T, ID> idExtractor;

    public JsonDAO(String filePath, Class<T> entityClass, Function<T, ID> idExtractor) {
        this.filePath = filePath;
        this.entityClass = entityClass;
        this.idExtractor = idExtractor;
        load();
    }

    /** Reads the file into {@link #store}. A missing or empty file means an empty store. */
    protected void load() {
        // TODO
    }

    /** Writes the whole store to the file. */
    protected void flush() {
        // TODO
    }

    @Override
    public void save(T entity) {
        // TODO
    }

    @Override
    public T findById(ID id) {
        // TODO
        return null;
    }

    @Override
    public List<T> findAll() {
        // TODO
        return List.of();
    }

    @Override
    public void update(T entity) {
        // TODO
    }

    @Override
    public void delete(ID id) {
        // TODO
    }

    @Override
    public boolean existsById(ID id) {
        // TODO
        return false;
    }
}