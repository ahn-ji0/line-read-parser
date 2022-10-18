package com.line.dao;

import com.line.context.User;

import java.sql.*;

public abstract class UserDao {
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
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
        Connection conn = getConnection();

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
