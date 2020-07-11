package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImp implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        TypedQuery<Role> query =sessionFactory.getCurrentSession().createQuery("FROM Role WHERE id = :id");
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }

}
