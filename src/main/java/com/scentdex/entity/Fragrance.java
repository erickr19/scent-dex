package com.scentdex.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Fragrance entity
 * A representation of a fragrance as a JavaBean.
 * Contains properties such as id, name, designer, and more.
 * @author ereyes3
 */

@Entity(name = "Fragrance")
@Table(name = "fragrances")
public class Fragrance {
    /**
     * Empty constructor
     */
    public Fragrance() {}

    /**
     * Constructor that creates a new Fragrance
     * @param id The id
     * @param reviews The reviews
     * @param wishlists The wishlists
     * @param name The name
     * @param designer The designer
     * @param scentNotes The notes
     * @param description The description
     * @param pricing The pricing
     */
    public Fragrance(int id, Set<Review> reviews, Set<Wishlist> wishlists, String name, String designer, String scentNotes, String description, String pricing) {
        this.id = id;
        this.reviews = reviews;
        this.wishlists = wishlists;
        this.name = name;
        this.designer = designer;
        this.scentNotes = scentNotes;
        this.description = description;
        this.pricing = pricing;
    }

    // instance variables

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // reviews
    @OneToMany(mappedBy = "reviews")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "wishlist")
    private Set<Wishlist> wishlists = new HashSet<>();

    // name
    @Column(name = "name")
    private String name;

    // designer
    @Column(name = "designer")
    private String designer;

    // scent notes
    @Column(name = "scent_notes")
    private String scentNotes;

    // description
    @Column(name = "description")
    private String description;

    // pricing
    @Column(name = "pricing")
    private String pricing;

    // setters and getters

    /**
     * Returns fragrance id
     * @return id The id of the fragrance
     */
    public int getId() {
        return id;
    }

    /**
     * Sets fragrance id
     * @param id The id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns fragrance name
     * @return name The fragrance name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets fragrance name
     * @param name The fragrance name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns designer name
     * @return designer The designer's name
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * Sets designer name
     * @param designer The designer's name
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * Returns fragrance notes
     * @return The notes of the fragrance
     */
    public String getScentNotes() {
        return scentNotes;
    }

    /**
     * Sets the fragrance notes
     * @param scentNotes The notes of the fragrance
     */
    public void setScentNotes(String scentNotes) {
        this.scentNotes = scentNotes;
    }

    /**
     * Returns the description
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the pricing
     * @return Pricing of
     */
    public String getPricing() {
        return pricing;
    }

    /**
     * Sets the pricing
     * @param pricing The pricing
     */
    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    /**
     * Gets reviews with specified fragrance
     * @return reviews with specified fragrance
     */
    public Set<Review> getReviews() {
        return reviews;
    }

    /**
     * Sets the reviews with specified fragrance
     * @param reviews
     */
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Gets wishlists with specified fragrance
     * @return
     */
    public Set<Wishlist> getWishlists() {
        return wishlists;
    }

    /**
     * Sets wishlists with specified fragrance
     * @param wishlists
     */
    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    /**
     * Lists all the properties of a fragrance
     * @return properties for a fragrance
     */
    @Override
    public String toString() {
        return "Fragrance{" +
                "name='" + name + '\'' +
                ", designer='" + designer + '\'' +
                ", scent notes='" + scentNotes + '\'' +
                ", description='" + description + '\'' +
                ", pricing='" + pricing + '\'' +
                '}';
    }
}
