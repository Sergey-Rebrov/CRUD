package com.firsttask.dao;


import com.firsttask.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Sergey on 20.11.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("Book successfully added. Book details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Book successfully updated. Book details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            logger.info("Book successfully removed. Book details: " + user);
        } else logger.info("Book doesn`t exist for id = " + id);
    }

    @Override
    public User getUserByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        logger.info("Book successfully loaded. Book details: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(String search, Integer offset, Integer maxResults) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User WHERE name LIKE :paramName");
        query.setString("paramName", "%" + search + "%");
        query.setFirstResult(offset != null ? offset : 0);
        query.setMaxResults(maxResults != null ? maxResults : 10);
        List<User> listUsers = (List<User>) query.list();

        for (User user : listUsers) {
            logger.info("Book list" + user);
        }
        return listUsers;
    }

    @Override
    public Long countUsers(String search) {
        Session session = this.sessionFactory.getCurrentSession();
        String countQ = "Select count (f.id) from User f WHERE name LIKE :paramName";
        Query countQuery = session.createQuery(countQ);
        countQuery.setString("paramName", "%" + search + "%");
        return (Long) countQuery.uniqueResult();
    }
}
