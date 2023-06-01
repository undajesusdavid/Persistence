package com.undabits.persistence.adapters_factory;

import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.mysql.MysqlAdapter;
import com.undabits.persistence.adapters.IAdapter;

import java.util.HashMap;

public class MysqlAdapterFactory extends AdapterFactory{

    @Override
    protected IAdapter createAdapter(ConfigFileDb file) {

        HashMap<String,String> params = new HashMap<>();
        params.put("host",file.get("MYSQL_HOST"));
        params.put("port",file.get("MYSQL_PORT"));
        params.put("database",file.get("MYSQL_DB"));
        params.put("user",file.get("MYSQL_USER"));
        params.put("password",file.get("MYSQL_PASSWORD"));

        IAdapter adapterMysql = new MysqlAdapter(params);
        return adapterMysql;
    }
}
