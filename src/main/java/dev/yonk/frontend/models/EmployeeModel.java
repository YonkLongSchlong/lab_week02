package dev.yonk.frontend.models;

import dev.yonk.backend.enums.EmployeeStatus;
import dev.yonk.backend.models.Employee;
import dev.yonk.backend.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class EmployeeModel {


    @Inject
    private EmployeeService employeeService;
    @Inject
    public EmployeeModel(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> empList = employeeService.getAllEmployee();
        request.setAttribute("empList", empList);
        request.getRequestDispatcher("employee.jsp").forward(request,response);
    }

    public void addEmployee(HttpServletRequest req, HttpServletResponse res){
        String empName = req.getParameter("name");
        String empDob = req.getParameter("dob");
        String empPhone = req.getParameter("phone");
        String empEmail = req.getParameter("email");
        String empAddress = req.getParameter("address");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(empDob,dtf);

        Employee emp  = new Employee(empName,dob,empPhone,empEmail,empAddress, EmployeeStatus.ACTIVE);
        employeeService.addEmployee(emp);
    }

    public void deleteEmployee(HttpServletRequest req, HttpServletResponse res) {
        long id = Long.parseLong(req.getParameter("id"));
        employeeService.deleteEmployee(id);
    }

}
