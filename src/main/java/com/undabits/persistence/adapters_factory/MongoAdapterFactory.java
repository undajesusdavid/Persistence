package com.undabits.persistence.adapters_factory;

import com.undabits.persistence.adapters.mongodb.MongodbAdapter;
import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IAdapter;

public class MongoAdapterFactory extends AdapterFactory{

    @Override
    protected IAdapter createAdapter(ConfigFileDb file) {
        String host = file.get("MONGO_HOST");
        Integer port = Integer.parseInt(file.get("MONGO_PORT"));
        String db = file.get("MONGO_DB");
        String user = file.get("MONGO_USER");
        String pass = file.get("MONGO_PASSWORD");
        IAdapter adapterMongo = new MongodbAdapter(host,port,db,user,pass);
        return adapterMongo;
    }
}
