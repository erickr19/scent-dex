package com.scentdex.persistence;

import com.scentdex.entity.User;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserDao test
 * @author ereyes3
 */
class UserDaoTest {
    // instance variables
    GenericDao dao;
    Database db;
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL()
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
}