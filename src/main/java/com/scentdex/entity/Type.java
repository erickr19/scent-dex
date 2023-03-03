package com.scentdex.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Types entity
 * A representation of fragrance note types as a bean/
 * Contains properties such as id and name.
 * @author ereyes3
 */
@Entity(name = "Type")
@Table(name = "types")
public class Type {
    // instance variables

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
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

    //TODO: Make a toString() method with string builder
}
