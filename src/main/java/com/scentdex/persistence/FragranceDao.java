package com.scentdex.persistence;

import com.scentdex.entity.Fragrance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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

    /**
     * Inserts a new fragrance into the database
     * @param fragrance The fragrance object
     * @return The id of the newly inserted fragrance
     */
    public int insert(Fragrance fragrance) {
        // open session
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer id = null;
        // try to insert fragrance into db
        try {
            tx = session.beginTransaction();
            id = (Integer)session.save(fragrance);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to insert", hibernateE);
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * Returns a fragrance by their respective id
     * @param id The id of the fragrance to get
     * @return The fragrance with given id
     */
    public Fragrance getById(int id) {
        // open session
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Fragrance fragrance = null;
        // try to get fragrance from db
        try {
            tx = session.beginTransaction();
            fragrance = session.get(Fragrance.class, id);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to get by id", hibernateE);
        } finally {
            session.close();
        }
        return fragrance;
    }

    /**
     * Updates the existing fragrance in the database
     * @param fragrance The existing fragrance object
     */
    public void update(Fragrance fragrance) {
        // open session
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        // try to update fragrance
        try {
            tx = session.beginTransaction();
            session.update(fragrance);
            tx.commit();
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception: failed to update", hibernateE);
        }
    }

    /**
     * Deletes an existing fragrance in the database
     * @param fragrance The existing fragrance object
     */
    public void delete(Fragrance fragrance) {
        // open session
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(fragrance);
        } catch (HibernateException hibernateE) {
            if (tx != null) tx.rollback();
            logger.error("Error deleting from db", hibernateE);
        } finally {
            session.close();
        }
    }

    /**
     * Returns the list of all fragrances in the database
     * @return a list of all the fragrances
     */
    public List<Fragrance> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Fragrance> query = builder.createQuery(Fragrance.class);
        List<Fragrance> fragrances = session.createQuery(query).getResultList();
        session.close();
        return fragrances;
    }
}
