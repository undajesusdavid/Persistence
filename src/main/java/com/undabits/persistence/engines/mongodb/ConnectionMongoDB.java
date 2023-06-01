package com.undabits.persistence.engines.mongodb;

import com.mongodb.MongoQueryException;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class ConnectionMongoDB {
    private String uri;
    private MongoDatabase connection;

    public  ConnectionMongoDB(String host, Integer port, String dataBase, String user, String password){
        Logger.getLogger("org.mongodb").setLevel(Level.OFF);

        if(!user.isEmpty() || !password.isEmpty()){
            this.uri = "mongodb://"+user+":"+password+"@"+host+":"+port+"/";
        }else{
            this.uri = "mongodb://"+host+":"+port+"/";
        }

        try{
            this.connection = this.connect(dataBase);
        }catch (Exception e){
            this.connection = null;
            System.out.println("No se pudo conectar con mongoDB");
            System.out.println("Error: "+e.getMessage());
        }

    }

    private MongoDatabase connect(String dataBase) throws  MongoQueryException{
        ConnectionString connectionString = new ConnectionString(this.uri);
        MongoDatabase db = MongoClients.create(connectionString).getDatabase(dataBase);
        return db;
    }

    public MongoCollection collection(String table){
        MongoCollection<Document> collection = this.connection.getCollection(table);
        return collection;
    }
}


