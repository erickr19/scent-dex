package com.scentdex.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 * Fragrance Data Access Object
 * Handles CRUD operations for ScentDex
 * @author ereyes3
 */
public class FragranceDao {
    // instantiate Logger and session factory
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    // methods
}
