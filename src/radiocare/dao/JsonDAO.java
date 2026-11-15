package radiocare.dao;

import radiocare.exception.PersistenceException;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;

public class JsonDAO<T, ID> {

    private final LinkedHashMap<ID, T> store = new LinkedHashMap<>();
    private final Path file;
    private final Class<T> type;
    private final Function<T, ID> getId;

    public JsonDAO(String filePath, Class<T> type, Function<T, ID> getId) {
        this.file = Path.of(filePath);
        this.type = type;
        this.getId = getId;
        load();
    }

    protected void load() {
        if(!Files.exists(file)){
            return;
        }
        try {
            String json = Files.readString(file);
            // comment this function out and import gson
            List<T> list = gson.fromJson(json, TypeToken.getParameterized(List.class, type).getType());
            if (list != null) {
                for (T item : list) {
                    store.put(getId.apply(item), item);
                }
            }
        } catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

    protected void write() {
        // TODO
    }

    public void save(T entity) {
        ID id = getId.apply(entity);
        if (store.containsKey(id)) {
            throw new IllegalArgumentException("ID deja existant: " + id);
        }
        store.put(id, entity);
        try {
            write();
        } catch (PersistenceException e) {
            store.remove(id);               // keep memory and file consistent
            throw e;
        }
    }

    public void update(T entity) {
        ID id = getId.apply(entity);
        if (!store.containsKey(id)) {
            throw new IllegalArgumentException("ID introuvable: " + id);
        }
        T ancien = store.put(id, entity);
        try {
            write();
        } catch (PersistenceException e) {
            store.put(id, ancien);
            throw e;
        }
    }

    public void delete(ID id) {
        if (!store.containsKey(id)) {
            throw new IllegalArgumentException("ID introuvable: " + id);
        }
        T ancien = store.remove(id);
        try {
            write();
        } catch (PersistenceException e) {
            store.put(id, ancien);
            throw e;
        }
    }

    public T findById(ID id) {
        return store.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }


    public boolean existsById(ID id) {
        return store.containsKey(id);
    }
}