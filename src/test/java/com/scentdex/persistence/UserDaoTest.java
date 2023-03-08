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
    GenericDao dao;
    // declare db
    Database db;
    // declare user list
    List<User> users;
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL("/scent-dex-dump.sql");
        users = dao.getAll();
    }

    @Test
    void insert() {
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