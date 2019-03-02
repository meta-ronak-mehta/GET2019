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

import com.metacube.ead7.model.Admin;

@Repository
@Transactional
public class AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 
     * @param username
     *            of admin
     * @param password
     *            of admin
     * @return true if this credentials matches in database
     */
    public boolean isValidAdmin(String username, String password) {
        List<Admin> admins = getAllAdmin();
        for (Admin ad : admins) {
            if (username.equals(ad.getUsername())
                    && password.equals(ad.getPassword()))
                return true;
        }
        return false;
    }

    /**
     * 
     * @return list of all admins
     */
    private List<Admin> getAllAdmin() {
        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> query = criteriaBuilder
                    .createQuery(Admin.class);
            Root<Admin> admin = query.from(Admin.class);
            query.select(admin);
            return session.createQuery(query).getResultList();
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
