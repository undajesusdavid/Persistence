package com.undabits.persistence;

import com.undabits.persistence.adapters.IPersistenceAdapter;
import java.util.Iterator;
import java.util.Map;

public class Persistence {
    private IPersistenceAdapter dbAdapter;
    private String table;

    public Persistence(String table){
        LoadAdapter adapter = new LoadAdapter();
        this.dbAdapter = adapter.load();
        this.table = table;
    }

    public Boolean add(Map<String,Object> data){
        return this.dbAdapter.insert(this.table ,data);
    }

    public Iterator get(){
        return this.dbAdapter.getAll(this.table);
    }

    public Map<String,Object> get(String id){
        return this.dbAdapter.getOne(this.table,id);
    }

    public Boolean update(String id, Map<String, Object> data){
        return this.dbAdapter.update(this.table,id,data);
    }

    public Boolean remove(String id){
        return this.dbAdapter.delete(this.table,id);
    }

}
