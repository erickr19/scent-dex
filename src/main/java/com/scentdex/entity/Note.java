package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Notes entity
 * A representation of fragrance notes as a bean.
 * Contains properties like id, name, and type.
 * @author ereyes3
 */
@Entity(name = "Note")
@Table(name = "notes")
public class Note {
    /**
     * Empty constructor
     */
    public Note() {}

    /**
     * Constructor to create a new Note
     *
     * @param id          The id of the note
     * @param name        The name of the note
     * @param type      The type of the note
     * @param fragrances The fragrances the note is associated with
     */
    public Note(int id, String name, Type type, Set<Fragrance> fragrances) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fragrances = fragrances;
    }

    // instance variables
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // name
    @Column(name = "name")
    private String name;

    // foreign key
    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;

    // many to many
    @ManyToMany(mappedBy = "notes")
    private Set<Fragrance> fragrances = new HashSet<>();

    // setters and getters

    /**
     * Gets id of the note
     * @return note id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of the note
     * @param id the note id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the note
     * @return the note name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the note
     * @param name the note name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the id of the type
     * @return the type id
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type id
     * @param type the type of the id to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets the fragrances associated with the note
     * @return fragrances
     */
    public Set<Fragrance> getFragrances() {
        return fragrances;
    }

    /**
     * Sets the fragrances associated with the note
     * @param fragrances the fragrances to set
     */
    public void setFragrances(Set<Fragrance> fragrances) {
        this.fragrances = fragrances;
    }

    // TODO: Make a toString() method using string builder
}
