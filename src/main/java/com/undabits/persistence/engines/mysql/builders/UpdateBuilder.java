package com.undabits.persistence.engines.mysql.builders;

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
        StringBuilder queryString = new StringBuilder("UPDATE ").append(this.table).append(" SET ");
        queryString.append(this.buildSet("=",this.data));
        queryString.append(" WHERE ").append(this.buildWhere("=",this.equalCondition));
        return queryString.toString();
    }
}
