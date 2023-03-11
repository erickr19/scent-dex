package com.scentdex.persistence;

import com.scentdex.entity.Fragrance;
import com.scentdex.entity.User;
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
    GenericDao userDao;
    GenericDao fragranceDao;
    Database db;
    List<Wishlist> wishlists;
    @BeforeEach
    void setUp() {
        wishlistDao = new GenericDao(Wishlist.class);
        userDao = new GenericDao(User.class);
        fragranceDao = new GenericDao(Fragrance.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        wishlists = wishlistDao.getAll();
    }

    /**
     * Tests inserting a new wishlist into the database
     */
    @Test
    void insert() {
        // create a new wishlist
        Wishlist newWishlist = new Wishlist();
        // add user to wishlist
        newWishlist.setUser((User)userDao.getById(3));
        // add fragrance to wishlist
        newWishlist.setFragrance((Fragrance) fragranceDao.getById(2));
        // insert and get new wishlistId
        int newWishlistId = wishlistDao.insert(newWishlist);
        // get inserted wishlist
        Wishlist insertedWishlist = (Wishlist)wishlistDao.getById(newWishlistId);
        // test
        assertEquals(newWishlist.getFragrance().getName(), insertedWishlist.getFragrance().getName());
    }

    /**
     * Tests getting a wishlist by id
     */
    @Test
    void getById() {
        // get wishlist
        Wishlist fetchedWishlist = (Wishlist)wishlistDao.getById(1);
        // test
        assertEquals(1, fetchedWishlist.getWishlistId());
        assertEquals(1, fetchedWishlist.getUser().getUserId());
        assertEquals(1, fetchedWishlist.getFragrance().getFragranceId());
    }

    /**
     * Tests updating the wishlist
     */
    @Test
    void update() {
        // replacing fragrance
        Fragrance newFragranceReplacement = (Fragrance)fragranceDao.getById(2);
        // get wishlist of update
        Wishlist wishlistToUpdate = (Wishlist)wishlistDao.getById(1);
        // set new fragrance
        wishlistToUpdate.setFragrance(newFragranceReplacement);
        // call update method
        wishlistDao.update(wishlistToUpdate);
        // get wishlist again
        Wishlist updatedWishlist = (Wishlist)wishlistDao.getById(1);
        // test
        assertEquals(newFragranceReplacement.getName(), updatedWishlist.getFragrance().getName());
    }

    /**
     * Tests deleting a wishlist
     * TODO: ensure that associated user is NOT deleted when deleting a wishlist
     */
    @Test
    void delete() {
        // delete wishlist
        wishlistDao.delete(wishlistDao.getById(1));
        // test
        assertNull(wishlistDao.getById(1));
    }

    /**
     * Tests getting all wishlists
     */
    @Test
    void getAll() {
        // test
        assertTrue(wishlists.size() > 0);
        assertFalse(wishlists.get(0).getFragrance().getName().equals(""));
    }

    // a findByPropertyEqual test would not make sense for this DAO
    // since the table is just for relations between entities
    // @Test
    // void findByPropertyEqual() {
    // }
}