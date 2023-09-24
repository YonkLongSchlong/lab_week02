package dev.yonk.lab_week02.repositories;

import dev.yonk.lab_week02.enums.ProductStatus;
import dev.yonk.lab_week02.models.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped

public class ProductRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    EntityTransaction trans =  em.getTransaction();

    Logger LOGGER = LogManager.getLogger(ProductRepository.class);
    public List<Product> getAllProduct() {
        try {
            return em.createNamedQuery("Product.findAll", Product.class).getResultList();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Optional<Product> getProductById (long id) {
        try {
            trans.begin();
            TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = :id", Product.class);
            query.setParameter("id", id);
            Product product = query.getSingleResult();
            trans.commit();
            return product == null ? Optional.empty() : Optional.of(product);
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public void addProduct (Product product) {
        try {
            trans.begin();
           em.persist(product);
           trans.commit();
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateProduct (Product product) {
        try {
           trans.begin();
           em.merge(product);
           trans.commit();
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }

}
