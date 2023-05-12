package com.undabits.persistence.adapters.factory;

import com.undabits.persistence.adapters.PostgresqlAdapter;
import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IPersistenceAdapter;

public class PostgreAdapterFactory extends AdapterFactory {
    @Override
    protected IPersistenceAdapter createAdapter(ConfigFileDb file) {
        String host   = file.get("POSTGRE_HOST");
        Integer port  = Integer.parseInt(file.get("POSTGRE_PORT"));
        String db     = file.get("POSTGRE_DB");
        String user   = file.get("POSTGRE_USER");
        String pass   = file.get("POSTGRE_PASSWORD");
        IPersistenceAdapter adapterPostgre = new PostgresqlAdapter(host,port,db,user,pass);
        return adapterPostgre;
    }
}
