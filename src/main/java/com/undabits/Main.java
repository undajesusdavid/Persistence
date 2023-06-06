package com.undabits;
import com.undabits.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args){

        Persistence users = new Persistence("users");
        List<Map<String,Object>> dataList = new ArrayList<>();

        HashMap<String,Object> user1 = new HashMap<>();
        user1.put("id","8974");
        user1.put("email","kleiber@gmail.com");
        user1.put("edad",19);
        user1.put("name","kleiber");

        HashMap<String,Object> user2 = new HashMap<>();
        user2.put("id","0096");
        user2.put("email","Bernardo@gmail.com");
        user2.put("edad",32);
        user2.put("name","Bernardo");

        HashMap<String,Object> user3 = new HashMap<>();
        user3.put("id","7854");
        user3.put("email","Diego@gmail.com");
        user3.put("edad",31);
        user3.put("name","Diego");

        HashMap<String,Object> user4 = new HashMap<>();
        user4.put("id","4178");
        user4.put("email","Pancho@gmail.com");
        user4.put("edad",45);
        user4.put("name","Pancho");

        HashMap<String,Object> user5 = new HashMap<>();
        user5.put("id","2306");
        user5.put("email","Victoria@gmail.com");
        user5.put("edad",17);
        user5.put("name","Victoria");

        dataList.add(user1);
        dataList.add(user2);
        dataList.add(user3);
        dataList.add(user4);
        dataList.add(user5);

        users.add(dataList);




    }

}


