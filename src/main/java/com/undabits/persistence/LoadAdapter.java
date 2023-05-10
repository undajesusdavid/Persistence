package com.undabits.persistence;

import com.undabits.persistence.adapters.IPersistenceAdapter;
import com.undabits.persistence.adapters.factory.AdapterFactory;
import com.undabits.persistence.adapters.factory.RegisterFactory;

import java.util.HashMap;

public class LoadAdapter {
    private ConfigFileDb config;
    private RegisterFactory factories;
    public LoadAdapter(){
        this.config = new ConfigFileDb();
        this.factories = new RegisterFactory();
    }

    public IPersistenceAdapter load(){
        AdapterFactory factory = this.factories.get(this.config.getCurrentAdapter());
        IPersistenceAdapter adapter = factory.getAdapter(this.config);
        return adapter;
    }


}
