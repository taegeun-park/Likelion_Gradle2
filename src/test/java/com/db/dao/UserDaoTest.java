package com.db.dao;

import com.db.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    void addAndGet() {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        String id = "1";
        userDao.add(new User(id, "Taegeun", "1234"));
        User user = userDao.findById(id);

        assertEquals("Taegeun", user.getName());
        assertEquals("1234", user.getPassword());
    }
}