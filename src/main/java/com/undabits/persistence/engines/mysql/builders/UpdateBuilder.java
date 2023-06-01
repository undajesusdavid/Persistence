package com.undabits.persistence.engines.mysql.builders;

import java.util.Iterator;
import java.util.Map;

public class UpdateBuilder extends QueryBuilder {

    private Map<String, Object> data;
    private Map<String,Object> equalCondition;

    public UpdateBuilder(String table, Map<String, Object> data){
        super(table);
        this.data = data;
    }

    public UpdateBuilder where(Map<String,Object> conditions){
        this.equalCondition = conditions;
        return  this;
    }


    @Override
    public String getQueryString() {

        String[] dataUpdate = new String[this.data.size()];
        Iterator keys = this.data.keySet().iterator();
        int counter = 0;
        while (keys.hasNext()){
            String key = keys.next().toString();
            String value = this.data.get(key).toString();
            StringBuilder sets = new StringBuilder(key).append("='").append(value).append("'");
            dataUpdate[counter] =  sets.toString();
            counter++;
        }

        StringBuilder queryString = new StringBuilder("UPDATE ").append(this.table).append(" SET ");
        queryString.append(String.join(",",dataUpdate));
        queryString.append(" WHERE ").append(this.buildWhere("=",this.equalCondition));

        return queryString.toString();
    }
}
