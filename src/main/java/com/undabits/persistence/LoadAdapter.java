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
        try{
            AdapterFactory factory = this.factories.get(this.config.getCurrentAdapter());
            IAdapter adapter = factory.getAdapter(this.config);
            return adapter;
        }catch (InstantiationException e){
            System.out.println("Error al intentar instanciar un adapterFactory registrado");
            throw new RuntimeException(e.getMessage());

        }catch (IllegalAccessException e){
            System.out.println("Error por acceso ilegal al querer instanciar un adapterFactory registrado");
            throw new RuntimeException(e.getMessage());
        }
    }


}
