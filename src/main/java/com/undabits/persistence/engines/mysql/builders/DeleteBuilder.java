package com.undabits.persistence.engines.mysql.builders;

import java.util.Map;

public class DeleteBuilder extends  QueryBuilder{

    private Map<String,Object> equalCondition;
    public DeleteBuilder(String table, Map<String,Object> conditions) {
        super(table);
        this.equalCondition = conditions;
    }

    @Override
    public String getQueryString() {
        StringBuilder queryString = new StringBuilder("DELETE FROM ").append(this.table).append(" WHERE ");
        queryString.append(this.buildWhere("=",this.equalCondition));
        return queryString.toString();
    }
}
