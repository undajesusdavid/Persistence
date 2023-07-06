package com.undabits.persistence.adapters.postgresql;

import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.engines.postgresql.ConnectionPostgreSQL;
import com.undabits.persistence.result_structuring.QueryResult;
import org.bson.Document;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PostgresqlAdapter implements IAdapter {

    private ConnectionPostgreSQL postgre;

    public PostgresqlAdapter(String host, Integer port , String database, String user, String password){
        this.postgre = new ConnectionPostgreSQL(host,port,database,user,password);
    }

    @Override
    public QueryResult insert(String table, JSONObject data) {
        //this.postgre.statement().executeQuery("INSERT INTO "+table+" () VALUES (valor1, valor2, valor3, .)");
        return null;
    }

    @Override
    public QueryResult multipleInsert(String table, List<JSONObject> listData) {
        return null;
    }

    @Override
    public QueryResult update(String table, String id, Map<String,Object> data) {
        return null;
    }

    @Override
    public QueryResult delete(String table, String id) {
        return null;
    }

    @Override
    public QueryResult getAll(String table) {
        return null;
    }

    @Override
    public QueryResult getOne(String table, String id) {
        return null;
    }

}
