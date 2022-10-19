package com.line.dao;

import com.line.connection.AWSConnMaker;
import com.line.dao.classExample.AWSConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao(){
        AWSConnMaker awsConnMaker = new AWSConnMaker();
        UserDao userDao = new UserDao(awsConnMaker);
        return userDao;
    }

//    public UserDao localUserDao(){
//        LocalConnMaker localConnMaker = new LocalConnMaker();
//        UserDao userDao = new LocalDao(localConnMaker);
//        return userDao;
//    }

}
