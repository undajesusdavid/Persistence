package com.undabits.persistence.result_structuring.converters;

import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultsetToList implements Convert {

    private ResultSet data;
    private List<JSONObject> resultData;

    public ResultsetToList(ResultSet data) {
        this.resultData = new ArrayList<JSONObject>();
        this.data = data;
    }

    @Override
    public List<JSONObject> convertData() {

        try{
            ResultSetMetaData metaData = this.data.getMetaData();
            int columnsNumber = metaData.getColumnCount();
            while (this.data.next()){
                JSONObject obj = new JSONObject();
                for (int i = 1; i < columnsNumber + 1; i++){
                    String key = metaData.getColumnName(i);
                    Object value =  this.data.getObject(i);
                    obj.put(key,value);
                }
                this.resultData.add(obj);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("ERROR AL INTENTAR CONVERTIR DATOS DE RESULTSET A  LIST<JSONObject>");
            System.out.println(e.getMessage());
        }

        return this.resultData;
    }
}
