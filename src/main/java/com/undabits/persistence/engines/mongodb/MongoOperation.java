package com.undabits.persistence.engines.mongodb;

import com.mongodb.MongoQueryException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;
import java.util.List;

public interface MongoOperation {

    public List<JSONObject> executeMongoOperation(MongoCollection<Document> collection) throws MongoQueryException;
}
