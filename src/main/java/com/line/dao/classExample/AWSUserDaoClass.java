package com.line.dao.classExample;

import com.line.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AWSUserDaoClass {

    AWSConnectionMaker awsConnectionMaker;

    public AWSUserDaoClass(){
        this.awsConnectionMaker = new AWSConnectionMaker();
    }
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = awsConnectionMaker.makeConnection();
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO users(id,name,password) VALUES (?,?,?)");
        pstm.setString(1,user.getId());
        pstm.setString(2,user.getName());
        pstm.setString(3, user.getPassword());

        int status = pstm.executeUpdate();
        System.out.println(status);

        pstm.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection conn = awsConnectionMaker.makeConnection();
        PreparedStatement pstm = conn.prepareStatement("SELECT id, name, password FROM users WHERE id = ?");
        pstm.setString(1,id);

        ResultSet rs = pstm.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));

        rs.close();
        pstm.close();
        conn.close();

        return user;
    }

}
