package com.scentdex.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Types entity
 * A representation of fragrance note types as a bean/
 * Contains properties such as id and name.
 * @author ereyes3
 */
@Entity(name = "Type")
@Table(name = "types")
public class Type {
    /**
     * Empty constructor
     */
    public Type() {}

    /**
     * Constructor that creates a new Type
     * @param id The id of the type
     * @param name The type name
     */
    public Type(int id, String name, Set<Note> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    // instance variables


    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // notes
    @OneToMany(mappedBy = "note")
    private Set<Note> notes = new HashSet<>();

    //name
    @Column(name = "name")
    private String name;

    // setters and getters

    /**
     * Get id of type
     * @return the type's id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id of type
     * @param id The id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the type
     * @return The type name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the type
     * @param name The name of the type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets notes of this type
     * @return notes
     */
    public Set<Note> getNotes() {
        return notes;
    }

    /**
     * Sets notes of this type
     * @param notes
     */
    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    //TODO: Make a toString() method with string builder
}
