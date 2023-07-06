package com.undabits.persistence.engines.mysql.builders;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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

    protected String buildSet(String operator,Map<String,Object> data){
        Iterator keys = data.keySet().iterator();
        StringBuilder dataSet = new StringBuilder();
        while(keys.hasNext()){
            String key = (String) keys.next();
            dataSet.append(key).append(operator).append("'").append(data.get(key)).append("'");
            if(keys.hasNext()){
                dataSet.append(",");
            }
        }
        return dataSet.toString();
    }

    protected String buildFieldsOrValues(JSONObject data, boolean getValue){
        Iterator keys = data.keySet().iterator();
        StringBuilder fields = new StringBuilder("(");
        while(keys.hasNext()){
            String key = (String) keys.next();
            if(getValue){
                if(data.get(key) instanceof String || data.get(key) instanceof LocalDateTime){
                    fields.append("'").append(data.get(key)).append("'");
                }else{
                    fields.append(data.get(key));
                }
            }else{
                fields.append(key);
            }
            if(keys.hasNext()){
                fields.append(",");
            }else{
                fields.append(")");
            }
        }
        return fields.toString();
    }

    protected String buildValueList(List<JSONObject> dataList){
        StringBuilder values = new StringBuilder();
        ListIterator<JSONObject> it = dataList.listIterator();

        while (it.hasNext()){
            JSONObject data = it.next();
            values.append(this.buildFieldsOrValues(data,true));

            if(it.hasNext()){
                values.append(",");
            }
        }
        return  values.toString();
    }



    public abstract String getQueryString();




}
