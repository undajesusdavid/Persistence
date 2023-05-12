package com.undabits.persistence.adapters;

import com.undabits.persistence.engines.ConnectionPostgreSQL;
import org.bson.Document;
import java.util.Iterator;
import java.util.Map;

public class PostgresqlAdapter implements IPersistenceAdapter {

    private ConnectionPostgreSQL postgre;

    public PostgresqlAdapter(String host, Integer port , String database, String user, String password){
        this.postgre = new ConnectionPostgreSQL(host,port,database,user,password);
    }

    @Override
    public Boolean insert(String table, Map<String,Object> data) {
        //this.postgre.statement().executeQuery("INSERT INTO "+table+" () VALUES (valor1, valor2, valor3, .)");
        return null;
    }

    @Override
    public Boolean update(String table, String id, Map<String,Object> data) {
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
    public Document getOne(String table, String id) {
        return null;
    }

    @Override
    public Iterator getWhere(String table, String val1, String condition, String val2) {
        return null;
    }
}
