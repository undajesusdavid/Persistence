package com.undabits.persistence.engines.mysql;

import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface MysqlOperation {

    public List<JSONObject> executeStatement(PreparedStatement ps) throws SQLException;


}
