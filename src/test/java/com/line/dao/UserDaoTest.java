package com.line.dao;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

// ../connection의 인터페이스 ConnMaker를 이용하여 connection 분리
// AWSConnMaker는 ConnMaker를 implement 하였음.

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("DB쿼리 실행")

    void addAndSelect() throws SQLException, ClassNotFoundException {

        UserDao userDao = context.getBean("awsUserDao",UserDao.class);

        userDao.deleteAll();

        User user = new User("1","안지영","3456");
        userDao.add(user);

        User selectedUser = userDao.get("1");
        Assertions.assertEquals("안지영",selectedUser.getName());

        Assertions.assertEquals(1,userDao.getCount());

    }
}