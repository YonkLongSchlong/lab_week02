package dev.yonk.backend.repositories;


import dev.yonk.backend.models.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    Logger LOGGER = LogManager.getLogger(EmployeeRepository.class);
    EntityTransaction trans =  em.getTransaction();

    public List<Employee> getAllEmpl() {
        try {
            trans.begin();
            List<Employee> lstEmployee;
            lstEmployee = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
            trans.commit();
            return lstEmployee;
        }catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Optional<Employee> getEmplById(long id)  {
        try {
            trans.begin();
            TypedQuery<Employee> query  = em.createQuery("select e from Employee e where e.id = :id", Employee.class);
            query.setParameter("id", id);
            Employee employee = query.getSingleResult();
            trans.commit();
            return employee == null ? Optional.empty() : Optional.of(employee);
        }catch (Exception e){
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public void addEmployee (Employee employee) {
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        } catch(Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        try{
            trans.begin();
            em.merge(employee);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            LOGGER.error(e.getMessage());
        }
    }
}
