package com.scentdex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Notes Javabean
 * @author ereyes3
 */
@Entity(name = "Note")
@Table(name = "notes")
public class Note {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int noteId;

    // name
    @Column(name = "name")
    private String name;

    // fragrance_notes
    @ManyToMany(mappedBy = "notes")
    private Set<Fragrance> fragrances = new HashSet<>();

    // constructors

    /**
     * Creates a new Note (empty)
     */
    public Note() {}

    /**
     * Creates a new Note
     * @param noteId noteId
     * @param name the note's name
     * @param fragrances the fragrances associated with the note
     */
    public Note(int noteId, String name, Set<Fragrance> fragrances) {
        this.noteId = noteId;
        this.name = name;
        this.fragrances = fragrances;
    }

    // setters and getters

    /**
     * Gets noteId
     * @return noteId
     */
    public int getNoteId() {
        return noteId;
    }

    /**
     * Sets noteId
     * @param noteId noteId
     */
    public void setNoteId(int noteId) {
        this.noteId = noteId;
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
     * @param name note name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets fragrances
     * @return fragrances
     */
    public Set<Fragrance> getFragrances() {
        return fragrances;
    }

    /**
     * Sets fragrances
     * @param fragrances fragrances associated with this note
     */
    public void setFragrances(Set<Fragrance> fragrances) {
        this.fragrances = fragrances;
    }
}
