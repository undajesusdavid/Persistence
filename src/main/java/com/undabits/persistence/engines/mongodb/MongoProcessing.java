package com.undabits.persistence.engines.mongodb;

import com.undabits.persistence.result_structuring.QueryResult;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class MongoProcessing extends ConnectionMongoDB {

    public MongoProcessing(Map<String, String> params) {
        super(params);
    }


    public QueryResult insert(Map<String, Object> data){
        QueryResult result = new QueryResult();
        return result;
    }



}
