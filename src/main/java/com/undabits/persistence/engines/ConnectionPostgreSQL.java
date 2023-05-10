package com.undabits.persistence.engines;


import java.sql.*;
import java.util.Properties;

public class ConnectionPostgreSQL {
    private  String host;
    private Integer port;
    private String database;
    private String user;
    private String password;

    private  Connection connection;

    public  ConnectionPostgreSQL(String host, Integer port, String database, String user, String password){
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
        this.connection = this.connect();
    }


    private Connection connect() {
        String url = "jdbc:postgresql://"+this.host+":"+this.port+"/"+ this.database+"";
        Properties props = new Properties();
        props.setProperty("user", "fred");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");

        try{
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public Statement statement(){
        try{
            Statement st = this.connection.createStatement();
            return st;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }


}
