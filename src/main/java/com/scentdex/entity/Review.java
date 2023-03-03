package com.scentdex.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Review entity
 * A representation of a review as a bean.
 * Contains properties such as review, rating, fragranceId, and userId
 * @author ereyes3
 */

@Entity(name = "Review")
@Table(name = "reviews")
public class Review {
    /**
     * Empty constructor
     */
    public Review() {}

    /**
     * Constructor that creates a new review
     * @param id The id of the review
     * @param user The user that owns the review
     * @param fragrance The review of the specified fragrance
     * @param review The body of the review
     * @param rating The rating of the review
     */
    public Review(int id, User user, Fragrance fragrance, String review, int rating) {
        this.id = id;
        this.user = user;
        this.fragrance = fragrance;
        this.review = review;
        this.rating = rating;
    }

    // instance variables
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // userId
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // fragranceId
    @ManyToOne
    @JoinColumn(name = "fragrance_id")
    private Fragrance fragrance;

    // review
    @Column(name = "review")
    private String review;

    // rating
    @Column(name = "rating")
    private int rating;

    /**
     * Gets review id
     * @return review id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of review
     * @param id The review id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets review body
     * @return The body of the review
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets review body
     * @param review The body of the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets rating of review
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets of rating of review
     * @param rating The rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user
     * @param user The user of the review
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets fragrance
     * @return the fragrance
     */
    public Fragrance getFragrance() {
        return fragrance;
    }

    /**
     * Sets the fragrance reviewed
     * @param fragrance the fragrance reviewed
     */
    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }


    // TODO: Create a toString() method with string builder
}
