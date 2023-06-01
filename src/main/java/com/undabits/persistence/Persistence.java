package com.undabits.persistence;

import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.result_structuring.QueryResult;

import java.util.Map;

public class Persistence {
    private IAdapter dbAdapter;
    private String table;

    public Persistence(String table){
        LoadAdapter adapter = new LoadAdapter();
        this.dbAdapter = adapter.load();
        this.table = table;
    }

    public QueryResult add(Map<String,Object> data){
        return this.dbAdapter.insert(this.table ,data);
    }

    public QueryResult get(){
        return this.dbAdapter.getAll(this.table);
    }

    public Map<String,Object> get(String id){
        return this.dbAdapter.getOne(this.table,id);
    }

    public QueryResult update(String id, Map<String, Object> data){
        return this.dbAdapter.update(this.table,id,data);
    }

    public Boolean remove(String id){
        return this.dbAdapter.delete(this.table,id);
    }

}
