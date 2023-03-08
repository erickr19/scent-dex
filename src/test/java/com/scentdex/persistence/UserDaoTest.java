package com.scentdex.persistence;

import com.scentdex.entity.User;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserDao test
 * @author ereyes3
 */
class UserDaoTest {
    // instance variables
    // declare dao
    GenericDao userDao;
    // declare db
    Database db;
    // declare user list
    List<User> users;
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL("/scent-dex-dump.sql");
        users = userDao.getAll();
    }

    @Test
    void insert() {
        // create new user
        User newUser = new User();
        // add user data
        newUser.setEmail("bobsmith@example.org");
        newUser.setPassword("bsmtih123");
        newUser.setUsername("smithyb");
        // get new userId
        int newUserId = userDao.insert(newUser);
        // get inserted user
        User insertedUser = (User) userDao.getById(newUserId);
        // assert equals test
        assertEquals("smithyb", insertedUser.getUsername());
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByProperty() {
    }

    @Test
    void testFindByProperty() {
    }

    /**
     * Tests getting all users
     */
    @Test
    void getAll() {
        assertTrue(users.size() > 0);
        assertFalse(users.get(0).getEmail().equals(""));
    }
}