package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Fragrance Javabean
 * @author ereyes3
 */
@Entity(name = "Fragrance")
@Table(name = "fragrances")
public class Fragrance {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int fragranceId;

    // name
    @Column(name = "name")
    private String name;

    // designer
    @Column(name = "designer")
    private String designer;

    // description
    @Column(name = "description")
    private String description;

    // pricing
    @Column(name = "pricing")
    private String pricing;

    // reviews
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fragrance")
    private Set<Review> review;

    // wishlist
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fragrance")
    private Set<Wishlist> wishlist;

    // fragrance_notes
    @ManyToMany
    @JoinTable(
            name = "fragrance_notes",
            joinColumns = { @JoinColumn(name = "fragrance_id") },
            inverseJoinColumns = { @JoinColumn(name = "note_id") }
    )
    private Set<Note> notes = new HashSet<>();
    // constructors

    /**
     * Creates a fragrance (empty)
     */
    public Fragrance() {}

    /**
     * Creates a fragrance
     * @param fragranceId the fragrance id
     * @param name the name
     * @param designer the designer
     * @param description the description
     * @param pricing the pricing
     * @param review the reviews associated with the fragrance
     * @param wishlist the wishlists associated with the fragrance
     * @param notes the notes associated with the fragrance
     */
    public Fragrance(int fragranceId, String name, String designer, String description, String pricing, Set<Review> review, Set<Wishlist> wishlist, Set<Note> notes) {
        this.fragranceId = fragranceId;
        this.name = name;
        this.designer = designer;
        this.description = description;
        this.pricing = pricing;
        this.review = review;
        this.wishlist = wishlist;
        this.notes = notes;
    }

    // setters and getters

    /**
     * Gets fragranceId
     * @return fragranceId
     */
    public int getFragranceId() {
        return fragranceId;
    }

    /**
     * Sets fragranceId
     * @param fragranceId the fragranceId
     */
    public void setFragranceId(int fragranceId) {
        this.fragranceId = fragranceId;
    }

    /**
     * Gets name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name fragrance name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets designer
     * @return designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * Sets designer
     * @param designer fragrance designer
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * Gets description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description fragrance description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets pricing
     * @return pricing
     */
    public String getPricing() {
        return pricing;
    }

    /**
     * Sets pricing
     * @param pricing fragrance pricing
     */
    public void setPricing(String pricing) {
        this.pricing = pricing;
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
     * @param review reviews of the fragrance
     */
    public void setReview(Set<Review> review) {
        this.review = review;
    }

    /**
     * Gets wishlists
     * @return wishlist
     */
    public Set<Wishlist> getWishlist() {
        return wishlist;
    }

    /**
     * Sets wishlists
     * @param wishlist the wishlists of the fragrance
     */
    public void setWishlist(Set<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    /**
     * Gets notes
     * @return notes
     */
    public Set<Note> getNotes() {
        return notes;
    }

    /**
     * Sets notes
     * @param notes the notes of the fragrance
     */
    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
