package com.undabits.persistence.engines.mysql.builders;

import java.util.Iterator;
import java.util.Map;

public abstract class QueryBuilder {

    protected String table;

    public QueryBuilder(String table){
        this.table = table;
    }

    protected String buildWhere(String operator, Map<String,Object> conditions){
        Iterator keys = conditions.keySet().iterator();
        StringBuilder condString = new StringBuilder();
        while(keys.hasNext()){
            String key = (String) keys.next();
            condString.append(key).append(operator).append(conditions.get(key));
            if(keys.hasNext()){
                condString.append(" AND ");
            }
        }
        return condString.toString();
    }


    public abstract String getQueryString();




}
