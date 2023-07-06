package com.undabits.persistence.adapters.mysql;

import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.engines.mysql.builders.DeleteBuilder;
import com.undabits.persistence.engines.mysql.builders.InsertBuilder;
import com.undabits.persistence.engines.mysql.builders.SelectBuilder;
import com.undabits.persistence.engines.mysql.QueryProcessing;
import com.undabits.persistence.engines.mysql.builders.UpdateBuilder;
import com.undabits.persistence.result_structuring.QueryResult;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MysqlAdapter implements IAdapter {
    private QueryProcessing mysql;
    public MysqlAdapter(Map<String,String> params) {
        this.mysql = new QueryProcessing(params);
    }
    @Override
    public QueryResult insert(String table, JSONObject data) {
        InsertBuilder queryBuilder = new InsertBuilder(table,data);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.insert(query);
        return  result;
    }

    @Override
    public QueryResult multipleInsert(String table, List<JSONObject> dataList) {
        InsertBuilder queryBuilder = new InsertBuilder(table,dataList);
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
    public QueryResult delete(String table, String id) {
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        DeleteBuilder queryBuilder = new DeleteBuilder(table,conditions);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.delete(query);
        return result;
    }
    @Override
    public QueryResult getOne(String table, String id) {
        SelectBuilder queryBuilder = new SelectBuilder(table);
        HashMap<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        queryBuilder.where(conditions);
        String query = queryBuilder.getQueryString();
        QueryResult result = this.mysql.select(query);
        return result;
    }

}
