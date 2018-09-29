package ru.bmstu.test.templebase.manager;

import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestBaseManager implements BaseManager<Temple, TempleFields> {
    private Map<Integer, Temple> templMap = new HashMap<>();

    @Override
    public void add(Temple temple) {

    }

    @Override
    public void addAll(Collection<Temple> temples) {

    }

    @Override
    public Temple get(int id) {
        return null;
    }

    @Override
    public void update(Temple temple) {

    }

    @Override
    public void updateAll(Collection<Temple> temples) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Collection<Temple> searchBy(TempleFields field, String value) {
        TempleFields.ID();
        return null;
    }
}
