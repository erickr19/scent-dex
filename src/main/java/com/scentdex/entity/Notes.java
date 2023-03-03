package com.scentdex.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Notes entity
 * A representation of fragrance notes as a bean.
 * Contains properties like id, name, and type.
 * @author ereyes3
 */
@Entity(name = "Note")
@Table(name = "notes")
public class Notes {
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
    @JoinColumn(name = "type_id")
    private Types typeId;

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
    public Types getTypeId() {
        return typeId;
    }

    /**
     * Sets the type id
     * @param typeId the tpye of the id to set
     */
    public void setTypeId(Types typeId) {
        this.typeId = typeId;
    }

    // TODO: Make a toString() method using string builder
}
