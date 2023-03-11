package com.scentdex.persistence;

import com.scentdex.entity.Fragrance;
import com.scentdex.entity.Note;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * NoteDao Test
 * @author ereyes3
 */
class NoteDaoTest {
    // instance variables
    GenericDao noteDao;
    GenericDao fragranceDao;
    Database db;
    List<Note> notes;
    @BeforeEach
    void setUp() {
        noteDao = new GenericDao(Note.class);
        fragranceDao = new GenericDao(Fragrance.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        notes = noteDao.getAll();
    }

    /**
     * Tests inserting a new Note into the database.
     */
    @Test
    void insert() {
        // create a new Note
        Note newNote = new Note();
        // add data to new note
        newNote.setName("Amber");
        // insert and get id of new note
        int newNoteId = noteDao.insert(newNote);
        // get inserted note
        Note insertedNote = (Note) noteDao.getById(newNoteId);
        // test
        assertEquals("Amber", insertedNote.getName());
    }

    /**
     * Tests getting a note by id
     */
    @Test
    void getById() {
        // get note
        Note fetchedNote = (Note)noteDao.getById(1);
        // test note
        assertEquals("Black pepper", fetchedNote.getName());
    }

    /**
     * Tests updating a note
     */
    @Test
    void update() {
        // new note name
        String newNoteName = "Black Pepper";
        // get note
        Note noteToUpdate = (Note)noteDao.getById(1);
        // set new note name
        noteToUpdate.setName(newNoteName);
        // call update method
        noteDao.update(noteToUpdate);
        // get user once again
        Note updatedNote = (Note)noteDao.getById(1);
        // test
        assertEquals(newNoteName, updatedNote.getName());
    }

    @Test
    // TODO: Figure out constraint violation
    void delete() {
        // delete note
        noteDao.delete(noteDao.getById(1));
        // test
        assertNull(noteDao.getById(1));
    }

    @Test
    void getAll() {
        assertTrue(notes.size() > 0);
        assertFalse(notes.get(0).getName().equals(""));
    }

    @Test
    void findByPropertyEqual() {
        // reset user list
        notes.clear();
        // get user with property
        notes = noteDao.findByPropertyEqual("name", "Geranium");
        // test
        assertTrue(notes.size() > 0);
        assertTrue(notes.get(0).getName().equals("Geranium"));
    }
}