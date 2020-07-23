package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE id = :id", Role.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }

}
