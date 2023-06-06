package com.undabits.persistence.result_structuring;

import com.undabits.persistence.result_structuring.converters.Convert;
import org.json.JSONObject;

import java.util.List;


public class QueryResult {

    private Boolean status;
    private String  messageError;
    private String messageSuccess;
    private Convert convert;
    private List<JSONObject> data;


    public QueryResult(){
    }

    public QueryResult(List<JSONObject> data){
        this.data = data;
    }

    public QueryResult(Convert convert){
        this.data = convert.convertData();
    }



    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public void setMessageSuccess(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMessageError() {
        return messageError;
    }

    public String getMessageSuccess() {
        return messageSuccess;
    }

    public List<JSONObject> getDataList() {
        return   this.data;
    }
    public JSONObject getDataFirst() {
        return   this.data.get(0);
    }
}
