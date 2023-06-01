package com.undabits.persistence.engines.mysql;

import com.undabits.persistence.result_structuring.converters.Convert;
import com.undabits.persistence.result_structuring.converters.ResultsetToList;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMysql {

    private StringBuilder uri;
    private String user;
    private String password;
    private Connection connection;

    public  ConnectionMysql(Map<String,String> params){
        this.uri = new StringBuilder("jdbc:mysql://")
                .append(params.get("host"))
                .append(":").append(params.get("port"))
                .append("/").append(params.get("database"));

        this.user = params.get("user");
        this.password = params.get("password");
    }


    private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.uri.toString(),user,password);
            System.out.println("Se conecto correctamente a la base de datos MYSQL");

        }catch (ClassNotFoundException |SQLException e){
            System.out.println("No se pudo conectar a la base de datos MYSQL");
            Logger.getLogger(ConnectionMysql.class.getName()).log(Level.SEVERE,null,e);
        }
        return this.connection;
    }


    private void disconnect(){
        try{
            this.connection.close();
        }catch (SQLException e){
            System.out.println("Error al desconectar la base de datos MYSQL");
            Logger.getLogger(ConnectionMysql.class.getName()).log(Level.SEVERE,null,e);
        }
    }


    protected List<JSONObject> executeQuery(String query, MysqlOperation operation){
        Connection con = this.connect();
        List<JSONObject> data = new ArrayList<JSONObject>();
        try{
            PreparedStatement ps = con.prepareStatement(query);
            data = operation.executeStatement(ps);

            //ResultSet result = ps.executeQuery();
            //Convert convert = new ResultsetToList(result);
            //data = convert.convertData();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        this.disconnect();

        return data;
    }



}
