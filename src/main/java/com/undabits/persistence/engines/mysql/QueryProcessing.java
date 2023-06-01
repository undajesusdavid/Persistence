package com.undabits.persistence.engines.mysql;

import com.undabits.persistence.result_structuring.QueryResult;
import com.undabits.persistence.result_structuring.converters.ResultsetToList;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
public class QueryProcessing extends ConnectionMysql {
    public QueryProcessing(Map<String, String> params) {
        super(params);
    }
    public QueryResult select(String query){
        List<JSONObject> dataList = this.executeQuery(query, (ps) -> {
            ResultSet resultset = ps.executeQuery();
            ResultsetToList convert = new ResultsetToList(resultset);
            List<JSONObject> data = convert.convertData();
            return data;
        });

        QueryResult result = new QueryResult(dataList);
        result.setStatus(true);
         return result;
    }

    public QueryResult insert(String query){
        List<JSONObject> dataList = this.executeQuery(query, (ps) -> {
            ps.executeUpdate();
            return null;
        });
        QueryResult result = new QueryResult(dataList);
        result.setStatus(true);
        return result;
    }

    public QueryResult update(String query){
        List<JSONObject> dataList = this.executeQuery(query, (ps) -> {
            ps.executeUpdate();
            return null;
        });

        QueryResult result = new QueryResult(dataList);
        result.setStatus(true);
        return result;
    }


}
