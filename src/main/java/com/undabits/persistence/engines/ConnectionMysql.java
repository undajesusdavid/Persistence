package com.undabits.persistence.engines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMysql {

    private String uri;
    private String user;
    private String password;
    private Connection connection;

    public  ConnectionMysql(String host, Integer port, String dataBase, String user, String password){
        this.uri = "jdbc:mysql://"+host+":"+port+"/"+dataBase;
        this.user = user;
        this.password = password;
    }

    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(uri,user,password);
            System.out.println("Se conecto correctamente a la base de datos MYSQL");

        }catch (ClassNotFoundException |SQLException e){
            System.out.println("No se pudo conectar a la base de datos MYSQL");
            Logger.getLogger(ConnectionMysql.class.getName()).log(Level.SEVERE,null,e);
        }
        return this.connection;
    }

    public void disconnect(){
        try{
            this.connection.close();
        }catch (SQLException e){
            System.out.println("Error al desconectar la base de datos MYSQL");
            Logger.getLogger(ConnectionMysql.class.getName()).log(Level.SEVERE,null,e);
        }
    }



}
