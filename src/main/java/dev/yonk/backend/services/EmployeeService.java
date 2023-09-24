package dev.yonk.backend.services;

import dev.yonk.backend.enums.EmployeeStatus;
import dev.yonk.backend.models.Employee;
import dev.yonk.backend.repositories.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
       return employeeRepository.getAllEmpl();
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.getEmplById(id);
    }

    public void addEmployee(Employee emp) {
        employeeRepository.addEmployee(emp);
    }

    public boolean updateEmployee(Employee emp, long id) {
        Optional<Employee> empOp = employeeRepository.getEmplById(id);
        if(empOp.isPresent()) {
            employeeRepository.updateEmployee(emp);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEmployee(long id) {
        Optional<Employee> empOp = employeeRepository.getEmplById(id);
        if(empOp.isPresent()) {
            Employee emp = empOp.get();
            emp.setStatus(EmployeeStatus.STOP);
            employeeRepository.updateEmployee(emp);
            return true;
        } else {
            return false;
        }
    }


}
