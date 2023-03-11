package com.scentdex.persistence;

import com.scentdex.entity.Fragrance;
import com.scentdex.entity.Review;
import com.scentdex.entity.User;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDaoTest {
    /**
     * ReviewDao test
     * @author ereyes3
     */
    GenericDao reviewDao;
    GenericDao userDao;
    GenericDao fragranceDao;
    Database db;
    List<Review> reviews;
    @BeforeEach
    void setUp() {
        reviewDao = new GenericDao(Review.class);
        userDao = new GenericDao(User.class);
        fragranceDao = new GenericDao(Fragrance.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        reviews = reviewDao.getAll();
    }

    /**
     * Tests inserting a new review into the database
     */
    @Test
    void insert() {
        // Create a new review
        Review newReview = new Review();
        // add data to review
        newReview.setUser((User)userDao.getById(1));
        newReview.setFragrance((Fragrance)fragranceDao.getById(2));
        newReview.setReview("Smells like clean linen and powdery with a hint of lavender. The subtle notes of amber in the base are very nice!");
        newReview.setRating(4);
        // insert and get new id
        int newReviewId = reviewDao.insert(newReview);
        // get inserted review
        Review insertedReview = (Review) reviewDao.getById(newReviewId);
        // test
        assertEquals(newReview.getUser().getUsername(), insertedReview.getUser().getUsername());
        assertEquals(newReview.getFragrance().getName(), insertedReview.getFragrance().getName());
        assertEquals(newReview.getReview(), insertedReview.getReview());
        assertEquals(newReview.getRating(), insertedReview.getRating());
    }

    /**
     * Tests getting by id
     */
    @Test
    void getById() {
        // get review
        Review fetchedReview = (Review)reviewDao.getById(1);
        // test
        assertEquals("erickrey", fetchedReview.getUser().getUsername());
    }

    /**
     * Tests updating a review
     */
    @Test
    void update() {
        // new review
        String newReview = "Overall a nice scent. This scent would work very well in the colder seasons. A little goes a long ways with this one!";
        // get review
        Review reviewToUpdate = (Review)reviewDao.getById(1);
        // set new review
        reviewToUpdate.setReview(newReview);
        // call update method
        reviewDao.update(reviewToUpdate);
        // get review again
        Review updatedReview = (Review)reviewDao.getById(1);
        // test
        assertEquals(newReview, updatedReview.getReview());
    }

    /**
     * Tests deleting a review
     */
    @Test
    void delete() {
        // delete review
        reviewDao.delete(reviewDao.getById(1));
        // test
        assertNull(reviewDao.getById(1));
    }

    /**
     * Tests getting all reviews
     */
    @Test
    void getAll() {
        assertTrue(reviews.size() > 0);
        assertFalse(reviews.get(0).getReview().equals(""));
    }

    /**
     * Tests finding by property
     */
    @Test
    void findByPropertyEqual() {
        // reset review list
        reviews.clear();
        // get review with property
        reviews = reviewDao.findByPropertyEqual("rating", 5);
        // test
        assertTrue(reviews.size() > 0);
        assertTrue(reviews.get(0).getFragrance().getName().equals("Eros Flame"));
    }
}