package com.undabits;
import com.undabits.persistence.Persistence;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        Persistence db = new Persistence("users");
        Iterator users = db.get();

        while (users.hasNext()){

            Map<String,Object>  user = (Map) users.next();


            System.out.println("Nombre : "+user.get("name"));

        }

    }

}


