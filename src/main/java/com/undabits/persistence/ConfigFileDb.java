package com.undabits.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileDb {

    private final String ROUTE_FILE = "src/main/java/com/undabits/persistence/config.properties";
    private Properties props;
    public ConfigFileDb() {
        this.props = new Properties();
        this.loadConfigFile();
    }

    private void loadConfigFile(){
        InputStream input;
        try{
            input = new FileInputStream(ROUTE_FILE);
            this.props.load(input);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String get(String key){
        return  this.props.getProperty(key);
    }

    public String getCurrentAdapter(){
        return this.props.getProperty("CURRENT_ENGINE");
    }





}
