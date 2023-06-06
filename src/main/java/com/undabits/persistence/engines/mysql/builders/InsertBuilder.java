package com.undabits.persistence.engines.mysql.builders;

import java.util.List;
import java.util.Map;

public class InsertBuilder extends QueryBuilder {

    private Map<String,Object>  data;
    private List<Map<String,Object>> dataList;

    public InsertBuilder(String table, Map<String,Object> data) {
        super(table);
        this.data = data;
    }

    public InsertBuilder(String table, List<Map<String,Object>> dataList) {
        super(table);
        this.dataList = dataList;
    }


    public String getQueryString(){
        String values = "";
        String fields =  "";
        if(this.data != null){
            values = this.buildFieldsOrValues(this.data,true);
            fields = this.buildFieldsOrValues(this.data,false);
        }else{
            values = this.buildValueList(this.dataList);
            fields = this.buildFieldsOrValues(this.dataList.get(0),false);
        }

        StringBuilder queryString = new StringBuilder("INSERT INTO ");
        queryString.append(this.table).append(fields);
        queryString.append(" VALUES ").append(values);

        System.out.println(queryString.toString());

        return queryString.toString();
    }










}
