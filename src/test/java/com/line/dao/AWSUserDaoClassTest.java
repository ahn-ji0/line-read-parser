package com.line.dao;

import com.line.domain.User;
import com.line.dao.classExample.AWSUserDaoClass;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class AWSUserDaoClassTest {
    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        AWSUserDaoClass awsUserDaoClass = new AWSUserDaoClass();
        User user = new User("20","비타민","1234");
        awsUserDaoClass.add(user);

        User user2 = awsUserDaoClass.get("20");
        System.out.println(user2.getName());
    }
}