package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Review Javabean
 * @author ereyes3
 */
@Entity(name = "Review")
@Table(name = "reviews")
public class Review {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int reviewId;

    // review
    @Column(name = "review")
    private String review;

    // rating
    @Column(name = "rating")
    private int rating;

    // fragrance
    @ManyToOne
    @JoinColumn(name = "fragrance_id")
    private Fragrance fragrance;

    // user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // constructors

    /**
     * Creates a new instance of a Review (empty)
     */
    public Review() {}

    /**
     * Creates a new instance of a Review
     * @param reviewId the review id
     * @param review the review
     * @param rating the rating (out of 5)
     * @param fragrance the fragrance being reviewed
     * @param user the user creating the review
     */
    public Review(int reviewId, String review, int rating, Fragrance fragrance, User user) {
        this.reviewId = reviewId;
        this.review = review;
        this.rating = rating;
        this.fragrance = fragrance;
        this.user = user;
    }

    // setters and getters

    /**
     * Gets the review id
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }

    /**
     * Sets the review id
     * @param reviewId reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * Gets the review
     * @return review
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets the review
     * @param review review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets the rating
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the review
     * @param rating the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the fragrance
     * @return fragrance
     */
    public Fragrance getFragrance() {
        return fragrance;
    }

    /**
     * Sets the fragrance
     * @param fragrance the fragrance
     */
    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }

    /**
     * Gets the user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
