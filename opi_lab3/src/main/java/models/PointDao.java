package models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PointDao implements Serializable {
    @PersistenceContext(unitName = "points")
    private EntityManager entityManager;

    public void createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("points");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addDotToDB(Point point) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(point);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
    }

    public List<Point> getDotsFromDB() {
        return entityManager.createQuery("select s from Point s order by s.id desc ", Point.class).getResultList();
    }
}