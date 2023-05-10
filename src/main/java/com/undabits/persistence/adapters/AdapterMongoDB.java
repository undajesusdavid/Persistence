package com.undabits.persistence.adapters;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.undabits.persistence.engines.ConnectionMongoDB;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class AdapterMongoDB implements IPersistenceAdapter {

    private ConnectionMongoDB mongo;

    public  AdapterMongoDB(String host, Integer port, String database, String user, String password){
        this.mongo = new ConnectionMongoDB(host,port,database,user,password);
    }


    private Bson toUpdateSetDocument(Map<String,Object> data){
        Iterator it = data.keySet().iterator();
        List<Bson> listUpdates = new ArrayList<>();
        while (it.hasNext()){
            String key = (String) it.next();
            listUpdates.add(Updates.set(key,data.get(key)));
        }
        return Updates.combine(listUpdates);
    }


    private Bson toDocument(Map<String,Object> data){
        return new Document(data);
    }


    @Override
    public Boolean insert(String table, Map<String,Object> data) {
        try {
            this.mongo.collection(table).insertOne(new Document(data));
            return true;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(String table, String id, Map<String,Object> data) {
        MongoCollection collection = this.mongo.collection(table);
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Bson updates = this.toUpdateSetDocument(data);
        try{
            collection.findOneAndUpdate(filter,updates);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean delete(String table, String id) {
        MongoCollection collection = this.mongo.collection(table);
        Bson filter = Filters.eq("_id", new ObjectId(id));

        try{
            collection.findOneAndDelete(filter);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterator getAll(String table) {
        MongoCollection collection = this.mongo.collection(table);
        return collection.find().iterator();
    }

    @Override
    public Map<String, Object> getOne(String table, String id) {
        MongoCollection collection = this.mongo.collection(table);
        Document find = (Document) collection.find(eq("_id",new ObjectId(id))).first();
        return find;

    }

    @Override
    public Iterator getWhere(String table, String val1, String condition, String val2) {
        return null;
    }
}
