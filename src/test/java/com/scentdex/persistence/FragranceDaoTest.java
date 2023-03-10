package com.scentdex.persistence;

import com.scentdex.entity.Fragrance;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FragranceDaoTest {
    // instance variables
    GenericDao fragranceDao;
    Database db;
    List<Fragrance> fragrances;
    @BeforeEach
    void setUp() {
        fragranceDao = new GenericDao(Fragrance.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        fragrances = fragranceDao.getAll();
    }

    /**
     * Tests adding a new fragrance to the database.
     */
    @Test
    void insert() {
        // create new fragrance
        Fragrance newFragrance = new Fragrance();
        // add data to new fragrance
        newFragrance.setName("Light Blue");
        newFragrance.setDesigner("Dolce & Gabbana");
        newFragrance.setDescription("The sensuality of sun-drenched skin, the bracing breeze of the Mediterranean Sea, the fruity and floral scents of the vegetation: Dolce&Gabbana Light Blue captures the quintessence of a summer day lulled by gentle waves lapping against the enchanting cliffs of Capri.");
        newFragrance.setPricing("$85");
        // insert fragrance and get id
        int newFragranceId = fragranceDao.insert(newFragrance);
        // get inserted fragrance
        Fragrance insertedFragrance = (Fragrance)fragranceDao.getById(newFragranceId);
        // test
        assertEquals(newFragrance.getName(), insertedFragrance.getName());
    }

    /**
     * Tests getting a fragrance by id.
     */
    @Test
    void getById() {
        // get fragrance
        Fragrance fetchedFragrance = (Fragrance)fragranceDao.getById(2);
        // test
        assertEquals(((Fragrance) fragranceDao.getById(2)).getName(), fetchedFragrance.getName());
    }

    /**
     * Tests updating a fragrance in the db.
     */
    @Test
    void update() {
        // new pricing
        String newPrice = "$60";
        // get fragrance
        Fragrance fragranceToUpdate = (Fragrance)fragranceDao.getById(2);
        // set new price
        fragranceToUpdate.setPricing(newPrice);
        // call update method
        fragranceDao.update(fragranceToUpdate);
        // get fragrance again
        Fragrance updatedFragrance = (Fragrance)fragranceDao.getById(2);
        // test
        assertEquals(newPrice, updatedFragrance.getPricing());
    }

    /**
     * Tests deleting a fragrance from the db
     */
    @Test
    void delete() {
        // delete fragrance
        fragranceDao.delete(fragranceDao.getById(1));
        // test
        assertNull(fragranceDao.getById(1));
    }

    /**
     * Tests getting all fragrances from the db.
     */
    @Test
    void getAll() {
        assertTrue(fragrances.size() > 0);
        assertFalse(fragrances.get(0).getName().equals(""));
    }

    /**
     * Tests finding by single property
     */
    @Test
    void findByPropertyEqual() {
        // reset fragrance list
        fragrances.clear();
        // get fragrance with property
        fragrances = fragranceDao.findByPropertyEqual("name", "Eros Flame");
        // test
        assertTrue(fragrances.size() > 0);
        assertTrue(fragrances.get(0).getName().equals("Eros Flame"));
    }
}