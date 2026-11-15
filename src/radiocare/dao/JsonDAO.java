package radiocare.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class JsonDAO<T, ID> {

    private final Map<ID, T> store = new LinkedHashMap<>();

    private final String filePath;

    private final Class<T> entityClass;

    private final Function<T, ID> idExtractor;

    public JsonDAO(String filePath, Class<T> entityClass, Function<T, ID> idExtractor) {
        this.filePath = filePath;
        this.entityClass = entityClass;
        this.idExtractor = idExtractor;
        load();
    }

    protected void load() {
        // TODO
    }

    protected void flush() {
        // TODO
    }

    public void save(T entity) {
        // TODO
    }

    public T findById(ID id) {
        // TODO
        return null;
    }

    public List<T> findAll() {
        // TODO
        return List.of();
    }

    public void update(T entity) {
        // TODO
    }

    public void delete(ID id) {
        // TODO
    }

    public boolean existsById(ID id) {
        // TODO
        return false;
    }
}