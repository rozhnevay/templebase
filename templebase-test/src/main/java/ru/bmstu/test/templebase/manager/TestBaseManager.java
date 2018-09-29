package ru.bmstu.test.templebase.manager;

import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestBaseManager implements BaseManager<Temple, TempleFields> {
    private Map<Integer, Temple> templeMap = new HashMap<>();

    @Override
    public void add(Temple temple) {
        templeMap.put(temple.getId(), temple);
    }

    @Override
    public void addAll(Collection<Temple> temples) {
        for (Temple t:temples) {
            add(t);
        }
    }

    @Override
    public Temple get(int id) {
        return templeMap.get(id);
    }

    @Override
    public void update(Temple temple) {
        templeMap.put(temple.getId(),temple);
    }

    @Override
    public void updateAll(Collection<Temple> temples) {
        for (Temple t:temples) {
            update(t);
        }
    }

    @Override
    public void delete(int id) {
        templeMap.remove(id);
    }

    @Override
    public Collection<Temple> searchBy(TempleFields field, String value) {
        TempleFields.ID();
        return null;
    }
}
