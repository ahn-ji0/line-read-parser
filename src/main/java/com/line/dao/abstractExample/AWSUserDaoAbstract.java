package com.line.dao.abstractExample;

import java.sql.*;
import java.util.Map;

public class AWSUserDaoAbstract extends UserDaoAbstract {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Map<String,String> env = System.getenv();
        Connection conn = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return conn;
    }

}
