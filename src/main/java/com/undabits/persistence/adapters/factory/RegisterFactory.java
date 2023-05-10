package com.undabits.persistence.adapters.factory;

import java.util.HashMap;
public class RegisterFactory {
    private HashMap<String, AdapterFactory> factories;
    public  RegisterFactory(){
        this.factories = new HashMap<>();
        this.register();
    }

    public AdapterFactory get(String engineName){
        return this.factories.get(engineName);
    }

    private void register(){
        this.factories.put("MONGO", new MongoAdapterFactory());
        this.factories.put("POSTGRE", new PostgreAdapterFactory());
        this.factories.put("MYSQL", new MysqlAdapterFactory());
    }




}
