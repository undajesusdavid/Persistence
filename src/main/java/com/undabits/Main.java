package com.undabits;
import com.undabits.persistence.Persistence;

import java.util.HashMap;


public class Main {

    public static void main(String[] args){
        Persistence users = new Persistence("users");
        HashMap<String,Object> user = new HashMap<>();
        user.put("Id","69854");
        user.put("name","jesus2");
        user.put("email","undajesusdavid@gmail.com");
        users.add(user);

    }

}


