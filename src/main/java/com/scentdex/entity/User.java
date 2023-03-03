package com.scentdex.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity
 * A representation of a user as a bean.
 * Contains properties such as creation date, email, password, and userId.
 * @author ereyes3
 */
@Entity(name = "User")
@Table(name = "users")
public class User {
    // constructors

    /**
     * Empty constructor
     */
    public User() {}

    /**
     * Constructor that creates a new User
     * @param id The id of the user
     * @param reviews The reviews of the user
     * @param wishlist The wishlist of the user
     * @param email The email of the user
     * @param password The password of the user
     */
    public User(int id, Set<Review> reviews, Set<Wishlist> wishlist, String email, String password) {
        this.id = id;
        this.reviews = reviews;
        this.wishlist = wishlist;
        this.email = email;
        this.password = password;
    }

    // instance variables
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // reviewId
    @OneToMany(mappedBy = "review")
    private Set<Review> reviews = new HashSet<>();

    // wishlistId
    @OneToMany(mappedBy = "wishlist")
    private Set<Wishlist> wishlist = new HashSet<>();

    // email
    @Column(name = "email")
    private String email;

    // password
    @Column(name = "password")
    private String password;

    // setters and getters

    /**
     * Gets user id
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets user id
     * @param id The user id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets email
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the users email
     * @param email The email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets reviews of the user
     * @return reviews
     */
    public Set<Review> getReviews() {
        return reviews;
    }

    /**
     * Sets reviews of the user
     * @param reviews the reviews to set
     */
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Get wishlist of the user
     * @return wishlist
     */
    public Set<Wishlist> getWishlist() {
        return wishlist;
    }

    /**
     * Set wishlist of the user
     * @param wishlists wishlist
     */
    public void setWishlist(Set<Wishlist> wishlists) {
        this.wishlist = wishlists;
    }

    // TODO: Create a toStiring() method with string builder
}
