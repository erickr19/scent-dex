package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * User Javabean
 * @author ereyes3
 */
@Entity(name = "User")
@Table(name = "users")
public class User {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int UserId;

    //email
    @Column(name = "email", nullable = false)
    private String email;

    // password
    @Column(name = "password", nullable = false)
    private String password;

    // username
    @Column(name = "username", nullable = false)
    private String username;

    // wishlist
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @PrimaryKeyJoinColumn
    private Wishlist wishlist;

    // review
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Review> review;

    // constructors

    /**
     * Creates a new User (empty)
     */
    public User() {}

    /**
     * Creates a new User
     * @param userId userId
     * @param email the email
     * @param password the password
     * @param username the username
     * @param wishlist wishlist of the user (nullable)
     * @param review the reviews the user has created
     */
    public User(int userId, String email, String password, String username, Wishlist wishlist, Set<Review> review) {
        UserId = userId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.wishlist = wishlist;
        this.review = review;
    }

    // setters and getters

    /**
     * Gets userId
     * @return userId
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * Sets userId
     * @param userId the userId
     */
    public void setUserId(int userId) {
        UserId = userId;
    }

    /**
     * Gets email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     * @param email user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets wishlist
     * @return wishlist
     */
    public Wishlist getWishlist() {
        return wishlist;
    }

    /**
     * Sets wishlist
     * @param wishlist wishlist
     */
    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    /**
     * Gets reviews
     * @return review
     */
    public Set<Review> getReview() {
        return review;
    }

    /**
     * Sets reviews
     * @param review user created reviews
     */
    public void setReview(Set<Review> review) {
        this.review = review;
    }
}
