package com.undabits.persistence.adapters;

import com.undabits.persistence.result_structuring.QueryResult;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface IAdapter {

    public QueryResult insert(String table, Map<String,Object> data);

    public  QueryResult update(String table,String id, Map<String,Object> data);

    public  Boolean delete(String table, String id);

    public QueryResult getAll(String table);

    public Map<String,Object> getOne(String table, String id);

    public Iterator getWhere(String table, String val1,String condition, String val2);


}
