package com.line.dao;

import com.line.context.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class AWSUserDaoAbstractTest {

    @Test
    @DisplayName("DB쿼리 실행")

    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDaoAbstract userDaoAbstract = new AWSUserDaoAbstract();
        User user = new User("9","헛개수","3456");
        userDaoAbstract.add(user);

        User selectedUser = userDaoAbstract.get("9");
        Assertions.assertEquals("헛개수",selectedUser.getName());
    }
}