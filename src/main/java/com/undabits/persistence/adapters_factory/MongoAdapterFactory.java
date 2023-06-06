package com.undabits.persistence.adapters_factory;

import com.undabits.persistence.adapters.mongodb.MongodbAdapter;
import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IAdapter;

import java.util.HashMap;

public class MongoAdapterFactory extends AdapterFactory{

    @Override
    protected IAdapter createAdapter(ConfigFileDb file) {

        HashMap<String,String> params = new HashMap<>();
        params.put("host",file.get("MONGO_HOST"));
        params.put("port",file.get("MONGO_PORT"));
        params.put("database",file.get("MONGO_DB"));
        params.put("user",file.get("MONGO_USER"));
        params.put("password",file.get("MONGO_PASSWORD"));

        IAdapter adapterMongo = new MongodbAdapter(params);
        return adapterMongo;
    }
}
