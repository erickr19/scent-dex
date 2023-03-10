package com.scentdex.persistence;

import com.scentdex.entity.Wishlist;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WishlistDao test
 * @author ereyes3
 */
class WishlistDaoTest {
    // instance variables
    GenericDao wishlistDao;
    Database db;
    List<Wishlist> wishlists;
    @BeforeEach
    void setUp() {
        wishlistDao = new GenericDao(Wishlist.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        wishlists = wishlistDao.getAll();
    }

    /**
     * Tests inserting a new user into the database
     */
    @Test
    void insert() {
        // create a new wishlist
        Wishlist newWishlist = new Wishlist();
        // add data to wishlist
        newWishlist.add
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
    void getAll() {
    }

    @Test
    void findByPropertyEqual() {
    }
}