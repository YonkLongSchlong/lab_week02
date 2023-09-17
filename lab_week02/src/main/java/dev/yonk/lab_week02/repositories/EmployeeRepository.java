package dev.yonk.lab_week02.repositories;


import dev.yonk.lab_week02.models.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class EmployeeRepository {
    @PersistenceContext
    EntityManagerFactory emf;
    EntityManager em = emf.createEntityManager();
    Logger LOGGER = LogManager.getLogger(EmployeeRepository.class);

    public List<Employee> getAllEmpl() {
        try {
            List<Employee> lstEmployee;
            lstEmployee = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
            return lstEmployee;
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Optional<Employee> getEmplById(String id)  {
        try {
            TypedQuery<Employee> query  = em.createQuery("select e from Employee e where e.id = :id", Employee.class);
            query.setParameter("id", id);
            Employee employee = query.getSingleResult();
            return employee == null ? Optional.empty() : Optional.of(employee);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public void addEmployee (Employee employee) {
        try {
            em.persist(employee);
        } catch(Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void delEmployee (Employee employee) {
        try {
            em.remove(employee);
        } catch(Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        try{
            TypedQuery<Employee> query = em.createQuery("update Employee e Set Employee = :employee where e.id = :id", Employee.class);
            query.setParameter("employee", employee);
            query.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
