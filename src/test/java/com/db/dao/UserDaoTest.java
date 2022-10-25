package com.db.dao;

import com.db.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    UserDao userDao;
    User user1;
    User user2;
    User user3;
    @BeforeEach
    public void setUp() {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
        this.user1 = new User("1","taegeun","0525");
        this.user2 = new User("2","hyogeun","0517");
        this.user3 = new User("3","jaegeun","0521");
    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();

        assertEquals(0, userDao.getCount());
        String id = "1";
//        User userNull = userDao.findById(id);
//        assertEquals("taegeun", userNull.getName());
//        assertEquals("0525", userNull.getPassword());
        userDao.add(user1);
        assertEquals(1, userDao.getCount());

        User user = userDao.findById(id);

        assertEquals("taegeun", user.getName());
        assertEquals("0525", user.getPassword());
    }
}