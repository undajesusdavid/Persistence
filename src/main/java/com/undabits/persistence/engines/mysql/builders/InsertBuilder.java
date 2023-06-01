package com.undabits.persistence.engines.mysql.builders;

import java.util.Iterator;
import java.util.Map;

public class InsertBuilder extends QueryBuilder {

    private Map<String,Object>  data;
    public InsertBuilder(String table, Map<String,Object> data) {
        super(table);
        this.data = data;
    }

    public String getQueryString(){

        String[] columns = new String[this.data.size()];
        String[] values = new String[this.data.size()];

        Iterator keys = this.data.keySet().iterator();
        int counter = 0;
        while (keys.hasNext()){
            String key = (String) keys.next();
            String value =  this.data.get(key).toString();
            columns[counter] = key;
            values[counter] = value;
            counter++;
        }
        StringBuilder queryString = new StringBuilder("INSERT INTO ");
        queryString.append(this.table).append(" (").append(String.join(",", columns)).append(") ");
        queryString.append("VALUES ('").append(String.join("','",values)).append("') ");

        return queryString.toString();
    }










}
