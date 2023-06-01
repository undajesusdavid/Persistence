package com.undabits.persistence.adapters_factory;

import com.undabits.persistence.adapters.postgresql.PostgresqlAdapter;
import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IAdapter;

public class PostgreAdapterFactory extends AdapterFactory {
    @Override
    protected IAdapter createAdapter(ConfigFileDb file) {
        String host   = file.get("POSTGRE_HOST");
        Integer port  = Integer.parseInt(file.get("POSTGRE_PORT"));
        String db     = file.get("POSTGRE_DB");
        String user   = file.get("POSTGRE_USER");
        String pass   = file.get("POSTGRE_PASSWORD");
        IAdapter adapterPostgre = new PostgresqlAdapter(host,port,db,user,pass);
        return adapterPostgre;
    }
}
