package com.undabits.persistence.adapters.factory;

import com.undabits.persistence.adapters.MongodbAdapter;
import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IPersistenceAdapter;

public class MongoAdapterFactory extends AdapterFactory{

    @Override
    protected IPersistenceAdapter createAdapter(ConfigFileDb file) {
        String host = file.get("MONGO_HOST");
        Integer port = Integer.parseInt(file.get("MONGO_PORT"));
        String db = file.get("MONGO_DB");
        String user = file.get("MONGO_USER");
        String pass = file.get("MONGO_PASSWORD");
        IPersistenceAdapter adapterMongo = new MongodbAdapter(host,port,db,user,pass);
        return adapterMongo;
    }
}
