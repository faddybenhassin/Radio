package radiocare.dao;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import radiocare.exception.PersistenceException;
import radiocare.util.JsonUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;

public class JsonDAO<T, ID> implements GenericDAO<T,ID> {

    private final LinkedHashMap<ID, T> store = new LinkedHashMap<>();
    private final Path file;
    private final Class<T> type;
    private final Function<T, ID> getId;
    private final Gson gson = JsonUtil.gson();

    public JsonDAO(String filePath, Class<T> type, Function<T, ID> getId) {
        this.file = Path.of(filePath);
        this.type = type;
        this.getId = getId;
        load();
    }

    private Type listType(){
        return TypeToken.getParameterized(List.class, type).getType();
    }
    protected void load() {
        if(!Files.exists(file)){
            return;
        }
        try {
            String json = Files.readString(file);
            // comment this function out and import gson
            List<T> list = gson.fromJson(json, listType());
            if (list != null) {
                for (T item : list) {
                    store.put(getId.apply(item), item);
                }
            }
        } catch (IOException | JsonIOException e){
            throw new PersistenceException("Echec lire: " + file, e);
        }
    }

    protected void write() {
        try {
            Files.createDirectories(file.toAbsolutePath().getParent());
            Files.writeString(file, gson.toJson(new ArrayList<>(store.values())));
        } catch (IOException | JsonIOException e) {
            throw new PersistenceException("Echec ecriture: " + file, e);
        }
    }
    @Override
    public void save(T entity) {
        ID id = getId.apply(entity);
        if (store.containsKey(id)) {
            throw new PersistenceException("ID deja existant: " + id);
        }
        store.put(id, entity);
        try {
            write();
        } catch (PersistenceException e) {
            store.remove(id);               // keep memory and file consistent
            throw e;
        }
    }
    @Override
    public void update(T entity) {
        ID id = getId.apply(entity);
        if (!store.containsKey(id)) {
            throw new PersistenceException("ID introuvable: " + id);
        }
        T ancien = store.put(id, entity);
        try {
            write();
        } catch (PersistenceException e) {
            store.put(id, ancien);
            throw e;
        }
    }
    @Override
    public void delete(ID id) {
        if (!store.containsKey(id)) {
            throw new PersistenceException("ID introuvable: " + id);
        }
        T ancien = store.remove(id);
        try {
            write();
        } catch (PersistenceException e) {
            store.put(id, ancien);
            throw e;
        }
    }
    @Override
    public T findById(ID id) {
        return store.get(id);
    }
    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean existsById(ID id) {
        return store.containsKey(id);
    }
}