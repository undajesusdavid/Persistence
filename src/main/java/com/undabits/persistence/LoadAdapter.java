package com.undabits.persistence;

import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.adapters_factory.AdapterFactory;
import com.undabits.persistence.adapters_factory.RegisterFactory;

public class LoadAdapter {
    private ConfigFileDb config;
    private RegisterFactory factories;
    public LoadAdapter(){
        this.config = new ConfigFileDb();
        this.factories = new RegisterFactory();
    }

    public IAdapter load(){
        AdapterFactory factory = this.factories.get(this.config.getCurrentAdapter());
        IAdapter adapter = factory.getAdapter(this.config);
        return adapter;
    }


}
