package com.undabits.persistence.engines.mongodb;

import com.mongodb.MongoQueryException;
import com.mongodb.client.MongoClient;

import com.mongodb.client.model.Updates;
import org.bson.Document;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.json.JSONObject;

public class ConnectionMongoDB {
    private String uri;
    private String database;
    private MongoClient client;

    public ConnectionMongoDB(Map<String,String> params){
        this.uri = buildUri(params);
        this.database = params.get("database");
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


    private MongoClient getClient(){
        try{
            ConnectionString connectionString = new ConnectionString(this.uri);
            this.client = MongoClients.create(connectionString);
        }catch (Exception e){
            throw new RuntimeException("No se pudo crear el cliente de mongo db en ConnectionMongoDB > getClient");
        }

        return  this.client;
    }


    protected List<JSONObject> executeQuery(String table, MongoOperation operation){
        List<JSONObject> data = new ArrayList<JSONObject>();
        try{
            MongoClient client  = this.getClient();
            MongoDatabase db = client.getDatabase(this.database);
            MongoCollection<Document> collection = db.getCollection(table);
            data = operation.executeMongoOperation(collection);
        }catch (MongoQueryException e){
            System.out.println("No se pudo conectar a la base de datos");
            System.out.println(e.getMessage());
        }
        this.client.close();
        return data;
    }


}


