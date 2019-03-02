package com.metacube.ead7.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.metacube.ead7.model.User;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 
     * @param user
     *            to be added
     * @return true if user added successfully
     */
    public boolean add(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 
     * @param id
     *            of user to be required
     * @return user of that id
     */
    public User getUserByID(Integer id) {

        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> user = query.from(User.class);
            query.select(user).where(criteriaBuilder.equal(user.get("id"), id));
            return session.createQuery(query).getSingleResult();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @return list of all user
     */
    public List<User> getAll() {
        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> user = query.from(User.class);
            query.select(user);
            return session.createQuery(query).getResultList();
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * @param user
     *            to be updated
     * @return true if user details updated successfully
     */
    public boolean update(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 
     * @param id
     *            of user to be deleted
     * @return true if user deleted from database
     */
    public boolean delete(Integer id) {
        try {
            User user = getUserByID(id);
            sessionFactory.getCurrentSession().delete(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 
     * @param attribute
     *            to be compare with
     * @param value
     *            of that attribute
     * @return list of user satisfy the condition
     */

    public List<User> getByAttribute(String attribute, String value) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(
                criteriaBuilder.equal(user.get(attribute), value));
        return session.createQuery(query).getResultList();
    }

}
