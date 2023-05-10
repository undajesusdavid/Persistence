package com.undabits.persistence.adapters;

import org.bson.Document;

import java.security.Key;
import java.util.Iterator;
import java.util.Map;

public interface IPersistenceAdapter {

    public Boolean insert(String table, Map<String,Object> data);

    public  Boolean update(String table,String id, Map<String,Object> data);

    public  Boolean delete(String table, String id);

    public Iterator getAll(String table);

    public Map<String,Object> getOne(String table, String id);

    public Iterator getWhere(String table, String val1,String condition, String val2);


}
