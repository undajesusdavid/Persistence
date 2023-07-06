package com.undabits.persistence.adapters.mongodb;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.engines.mongodb.ConnectionMongoDB;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.undabits.persistence.result_structuring.QueryResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MongodbAdapter implements IAdapter {

    private ConnectionMongoDB mongo;

    public MongodbAdapter(Map<String,String> params){
        this.mongo = new ConnectionMongoDB(params);
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
    public QueryResult insert(String table, JSONObject data) {
        /*try {
            this.mongo.collection(table).insertOne(new Document(data));
            return true;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }*/

        return null;
    }

    @Override
    public QueryResult multipleInsert(String table, List<JSONObject> listData) {
        return null;
    }

    @Override
    public QueryResult update(String table, String id, Map<String,Object> data) {
        /*MongoCollection collection = this.mongo.collection(table);
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Bson updates = this.toUpdateSetDocument(data);
        try{
            collection.findOneAndUpdate(filter,updates);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }*/

        return null;
    }

    @Override
    public QueryResult delete(String table, String id) {
        /*MongoCollection collection = this.mongo.collection(table);
        Bson filter = Filters.eq("_id", new ObjectId(id));

        try{
            collection.findOneAndDelete(filter);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }*/
        return  null;
    }

    @Override
    public QueryResult getAll(String table) {
        /*MongoCollection collection = this.mongo.collection(table);
        return collection.find().iterator();*/
        return null;
    }

    @Override
    public QueryResult getOne(String table, String id) {
        /*MongoCollection collection = this.mongo.collection(table);
        Document find = (Document) collection.find(eq("_id",new ObjectId(id))).first();
        return find;*/
        return null;

    }


}
