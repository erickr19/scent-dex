package com.scentdex.entity;

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
     * @param fragrance The fragrance the note is associated with
     */
    public Note(int id, String name, Type type, Fragrance fragrance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fragrance = fragrance;
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
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "fragrance_id")
    private Fragrance fragrance;

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
     * @param typeId the tpye of the id to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets the fragrance associated with the note
     * @return fragrance
     */
    public Fragrance getFragrance() {
        return fragrance;
    }

    /**
     * Sets the fragranceId associated with the note
     * @param fragrance fragrance
     */
    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }



    // TODO: Make a toString() method using string builder
}
