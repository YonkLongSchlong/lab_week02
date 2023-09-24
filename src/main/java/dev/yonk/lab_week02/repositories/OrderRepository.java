package dev.yonk.lab_week02.repositories;

import dev.yonk.lab_week02.models.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    Logger LOGGER = LogManager.getLogger(OrderRepository.class);
    EntityTransaction trans =  em.getTransaction();
     public List<Order> getAllOrder () {
         try {
             trans.begin();
            List<Order> lstOrder;
            lstOrder = em.createQuery("select o from Order o", Order.class).getResultList();
            trans.commit();
            return lstOrder;
         }catch (Exception e) {
             trans.rollback();
            LOGGER.error(e.getMessage());
         }
         return null;
     }

     public Optional<Order> getOrderById(long id) {
         try {
            trans.begin();
             TypedQuery<Order> query = em.createQuery("select o from Order o where o.id = :id", Order.class);
             query.setParameter("id", id);
             Order order = query.getSingleResult();
             trans.commit();
             return order == null ? Optional.empty() : Optional.of(order);
         } catch ( Exception e) {
             trans.rollback();
             LOGGER.error(e.getMessage());
         }
         return Optional.empty();
     }

     public void addOrder(Order order) {
         try {
             trans.begin();
             em.persist(order);
             trans.commit();
         } catch (Exception e) {
             trans.rollback();
             LOGGER.error(e.getMessage());
         }
     }

    public void updateOrder(Order order) {
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteOrder(Order order) {
        try {
            trans.begin();
            em.remove(order);

            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }

}
