package com.undabits.persistence.engines.mongodb;

import com.mongodb.MongoQueryException;
import org.bson.Document;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class ConnectionMongoDB {
    private String uri;
    private String database;
    private MongoDatabase connection;

    public ConnectionMongoDB(Map<String,String> params){
        this.uri = buildUri(params);
        this.database = params.get("database");
    }

    private MongoDatabase connect() throws  MongoQueryException{

        try{
            ConnectionString connectionString = new ConnectionString(this.uri);
            MongoDatabase db = MongoClients.create(connectionString).getDatabase(this.database);
            this.connection = db;
        }catch (Exception e){
            System.out.println("No se pudo conectar con mongoDB");
            System.out.println("Error: "+e.getMessage());
        }

        return this.connection;
    }

    public MongoCollection collection(String table){
        MongoCollection<Document> collection = this.connect().getCollection(table);
        return collection;
    }

    private String buildUri(Map<String,String> params){
        StringBuilder uri = new StringBuilder("mongodb://");
        String user = params.get("user");
        String password = params.get("password");
        if(!user.isEmpty() || !params.get("password").isEmpty()){
            uri.append(user).append(":").append(password).append("@");
        }
        uri.append(params.get("host")).append(":").append(params.get("port")).append("/");
        return uri.toString();
    }
}


