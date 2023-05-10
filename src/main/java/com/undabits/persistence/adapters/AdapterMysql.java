package com.undabits.persistence.adapters;

import java.util.Iterator;
import java.util.Map;

public class AdapterMysql implements IPersistenceAdapter{

    public AdapterMysql(String host, Integer port, String database, String user, String password) {
    }

    @Override
    public Boolean insert(String table, Map<String, Object> data) {
        return null;
    }

    @Override
    public Boolean update(String table, String id, Map<String, Object> data) {
        return null;
    }

    @Override
    public Boolean delete(String table, String id) {
        return null;
    }

    @Override
    public Iterator getAll(String table) {
        return null;
    }

    @Override
    public Map<String, Object> getOne(String table, String id) {
        return null;
    }

    @Override
    public Iterator getWhere(String table, String val1, String condition, String val2) {
        return null;
    }
}
