package com.undabits;
import com.undabits.persistence.Persistence;
import org.json.JSONObject;

import java.util.HashMap;


public class Main {
    public static void main(String[] args){
        Persistence users = new Persistence("users");
        HashMap<String,Object> newUser = new HashMap<>();
        newUser.put("edad",28);
        users.update("1234",newUser);

        for (JSONObject row : users.get().getData()){
            System.out.println(row);
        }


    }

}


