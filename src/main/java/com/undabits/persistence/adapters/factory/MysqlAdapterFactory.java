package com.undabits.persistence.adapters.factory;

import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.AdapterMysql;
import com.undabits.persistence.adapters.IPersistenceAdapter;

public class MysqlAdapterFactory extends AdapterFactory{

    @Override
    protected IPersistenceAdapter createAdapter(ConfigFileDb file) {
        String host   = file.get("MYSQL_HOST");
        Integer port  = Integer.parseInt(file.get("MYSQL_PORT"));
        String db     = file.get("MYSQL_DB");
        String user   = file.get("MYSQL_USER");
        String pass   = file.get("MYSQL_PASSWORD");
        IPersistenceAdapter adapterMysql = new AdapterMysql(host,port,db,user,pass);
        return adapterMysql;
    }
}
