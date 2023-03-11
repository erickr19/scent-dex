package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Wishlist Javabean
 * @author ereyes3
 */
@Entity(name = "Wishlist")
@Table(name = "wishlist")
public class Wishlist {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int wishlistId;

    // fragrance
    @ManyToOne
    @JoinColumn(name = "fragrance_id")
    private Fragrance fragrance;

    // user
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    // constructors

    /**
     * Creates a new Wishlist (empty)
     */
    public Wishlist() {}

    /**
     * Creates a new Wishlist
     * @param wishlistId the wishlist id
     * @param fragrance the fragrance being added to the list
     * @param user the user that the list belongs to
     */
    public Wishlist(int wishlistId, Fragrance fragrance, User user) {
        this.wishlistId = wishlistId;
        this.fragrance = fragrance;
        this.user = user;
    }

    // setters and getters

    /**
     * Gets wishlistId
     * @return wishlistId
     */
    public int getWishlistId() {
        return wishlistId;
    }

    /**
     * Sets wishlistId
     * @param wishlistId the wishlistId
     */
    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
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
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets fragrance
     * @return fragrance
     */
    public Fragrance getFragrance() {
        return fragrance;
    }

    /**
     * Sets fragrance
     * @param fragrance the fragrance
     */
    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }
}
