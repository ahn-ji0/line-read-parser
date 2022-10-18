package com.line.dao;

import java.sql.*;
import java.util.Map;

public class AWSUserDaoImpl extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Map<String,String> env = System.getenv();
        Connection conn = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return conn;
    }

}
