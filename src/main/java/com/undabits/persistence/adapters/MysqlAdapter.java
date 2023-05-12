package com.undabits.persistence.adapters;

import com.undabits.persistence.engines.ConnectionMysql;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MysqlAdapter implements IPersistenceAdapter {

    private ConnectionMysql mysql;

    public MysqlAdapter(String host, Integer port, String database, String user, String password) {
        this.mysql = new ConnectionMysql(host,port,database,user,password);

    }

    private Map<String,String> buildFieldsAndValues(Map data){
        String fields = "";
        String values = "";
        Iterator keys = data.keySet().iterator();
        while (keys.hasNext()){
            String key = (String) keys.next();
            String value = (String) data.get(key);
            if(keys.hasNext()){
                fields = fields+key+",";
                values = values+"'"+value+"',";
            }else{
                fields = fields+key;
                values = values+"'"+value+"'";
            }
        }

        Map<String,String> result = new HashMap<>();
        result.put("fields",fields);
        result.put("values",values);

        return result;
    }


    @Override
    public Boolean insert(String table, Map<String, Object> data) {

        Map dataJoin = this.buildFieldsAndValues(data);
        String sql = "Insert into "+table+"("+dataJoin.get("fields")+") values("+dataJoin.get("values")+")";
        try{
            PreparedStatement ps = this.mysql.connect().prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println("Error al ejecutar query");
            System.out.println(e.getMessage());
            return false;
        }

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
