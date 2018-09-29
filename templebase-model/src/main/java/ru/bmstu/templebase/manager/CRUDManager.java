package ru.bmstu.templebase.manager;

import java.util.Collection;

public interface CRUDManager<T, E extends Enum<E>> {
    void add(T t);
    void addAll(Collection<T> tCollection);
    T get(int id);
    void update(T t);
    void updateAll(Collection<T> tCollection);
    void delete(int id);

    Collection<T> searchBy(E field, String value);

}
