package com.undabits.persistence.adapters;

import com.undabits.persistence.result_structuring.QueryResult;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface IAdapter {

    public QueryResult insert(String table,JSONObject data);

    public  QueryResult multipleInsert(String table, List<JSONObject> dataList);

    public  QueryResult update(String table,String id, Map<String,Object> data);

    public  QueryResult delete(String table, String id);

    public QueryResult getAll(String table);

    public QueryResult getOne(String table, String id);


}
