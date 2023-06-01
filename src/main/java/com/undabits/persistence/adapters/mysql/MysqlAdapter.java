package com.undabits.persistence.adapters.mysql;
import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.engines.mysql.builders.InsertBuilder;
import com.undabits.persistence.engines.mysql.builders.SelectBuilder;
import com.undabits.persistence.engines.mysql.QueryProcessing;
import com.undabits.persistence.engines.mysql.builders.UpdateBuilder;
import com.undabits.persistence.result_structuring.QueryResult;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MysqlAdapter implements IAdapter {

    private QueryProcessing mysql;
    public MysqlAdapter(Map<String,String> params) {
        this.mysql = new QueryProcessing(params);
    }


    @Override
    public QueryResult insert(String table, Map<String, Object> data) {
        InsertBuilder queryBuilder = new InsertBuilder(table,data);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.insert(query);
        return  result;
    }

    @Override
    public QueryResult getAll(String table) {
        SelectBuilder queryBuilder = new SelectBuilder(table);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.select(query);
        return result;
    }

    @Override
    public QueryResult update(String table, String id, Map<String, Object> data) {
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        UpdateBuilder queryBuilder = new UpdateBuilder(table,data);
        queryBuilder.where(conditions);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.update(query);
        return result;
    }

    @Override
    public Boolean delete(String table, String id) {
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
