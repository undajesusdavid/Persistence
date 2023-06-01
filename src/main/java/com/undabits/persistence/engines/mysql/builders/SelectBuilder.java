package com.undabits.persistence.engines.mysql.builders;

import java.util.Map;

public class SelectBuilder extends QueryBuilder {


    private String[] arrayFields;
    private Map<String,Object> equalCondition;

    public SelectBuilder(String table){
        super(table);
    }

    public SelectBuilder fields(String[] fields){
        this.arrayFields =  fields;
        return this;
    }

    public SelectBuilder where(Map<String,Object> conditions){
        this.equalCondition = conditions;
        return this;
    }


    public String getQueryString(){
        StringBuilder queryString = new StringBuilder("SELECT ");
        String fieldString = "*";
        if(this.arrayFields != null && this.arrayFields.length > 0){
            fieldString = String.join(",", this.arrayFields);
        }
        queryString.append(fieldString).append(" ");
        queryString.append("FROM ").append(this.table).append(" ");

        if(this.equalCondition != null && !this.equalCondition.isEmpty()){
            queryString.append("WHERE ").append(this.buildWhere("=",this.equalCondition));
        }

        return queryString.toString();
    }











}
