package dev.yonk.lab_week02.services;

import dev.yonk.lab_week02.enums.EmployeeStatus;
import dev.yonk.lab_week02.models.Employee;
import dev.yonk.lab_week02.repositories.EmployeeRepository;
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

    public void updateEmployee(Employee emp) {
        employeeRepository.updateEmployee(emp);
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
