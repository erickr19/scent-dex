package com.scentdex.entity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Wishlist entity
 * A representation of a wishlist as a bean.
 * Contains properties such as id, addedTime, userId, and fragranceId.
 * @author ereyes3
 */

@Entity(name = "Wishlist")
@Table(name = "wishlist")
public class Wishlist {
    /**
     * Empty constructor
     */
    public Wishlist() {}

    /**
     * Constructor that creates a new Wishlist
     * @param id The id of the wishlist
     * @param user The user of the wishlist
     * @param fragrance The fragrance of the wishlist
     */
    public Wishlist(int id, User user, Fragrance fragrance) {
        this.id = id;
        this.user = user;
        this.fragrance = fragrance;
    }

    // instance variables
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fragrance")
    private Fragrance fragrance;

    /**
     * Gets id of the wishlist
     * @return the wishlist id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the wishlist id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user of the wishlist
     * @return the wishlist
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of the wishlist
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the fragrance from the wishlist
     * @return the fragrance
     */
    public Fragrance getFragrance() {
        return fragrance;
    }

    /**
     * Sets the fragrance in the wishlist
     * @param fragrance The fragrance
     */
    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }
}
