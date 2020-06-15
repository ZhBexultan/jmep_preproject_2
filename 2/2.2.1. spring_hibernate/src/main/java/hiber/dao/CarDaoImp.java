package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Car getCarById(Long id) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car WHERE id = :id");
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
