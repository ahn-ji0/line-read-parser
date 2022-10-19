package com.line.dao;

import com.line.connection.AWSConnMaker;
import com.line.connection.ConnMaker;
import com.line.context.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

// ../connection의 인터페이스 ConnMaker를 이용하여 connection 분리
// AWSConnMaker는 ConnMaker를 implement 하였음.

class UserDaoTest {

    @Test
    @DisplayName("DB쿼리 실행")

    void addAndSelect() throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDaoFactory().awsUserDao();
        User user = new User("3","안지영","3456");
        userDao.add(user);

        User selectedUser = userDao.get("3");
        Assertions.assertEquals("안지영",selectedUser.getName());
    }
}