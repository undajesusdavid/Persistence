package com.undabits.persistence.adapters_factory;

import java.util.HashMap;
public class RegisterFactory {
    private HashMap<String, Class> factories;

    public  RegisterFactory(){
        try{
            this.register();
        }catch (ClassNotFoundException ex){
            System.out.println("Ocurrio un error en el metodo donde se registran los adaptersFactory");
            System.out.println("Verifique que las rutas de las clases sean la correcta");
            System.out.println(ex.getMessage());
        }
    }

    public AdapterFactory get(String engineName) throws InstantiationException, IllegalAccessException {
        Class factory =  this.factories.get(engineName);
        return (AdapterFactory) factory.newInstance();
    }

    private void register() throws  ClassNotFoundException{
        this.factories = new HashMap<>();
        this.factories.put("MONGO",Class.forName("com.undabits.persistence.adapters_factory.MongoAdapterFactory"));
        this.factories.put("POSTGRE", Class.forName("com.undabits.persistence.adapters_factory.PostgreAdapterFactory"));
        this.factories.put("MYSQL", Class.forName("com.undabits.persistence.adapters_factory.MysqlAdapterFactory"));
    }




}
