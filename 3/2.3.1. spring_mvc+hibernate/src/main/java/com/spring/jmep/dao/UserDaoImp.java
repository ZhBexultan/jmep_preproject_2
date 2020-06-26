package com.spring.jmep.dao;

import com.spring.jmep.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query =sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id");
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUserById(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }
}
