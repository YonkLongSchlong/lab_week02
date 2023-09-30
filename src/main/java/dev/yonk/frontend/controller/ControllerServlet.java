package dev.yonk.frontend.controller;

import dev.yonk.backend.services.EmployeeService;
import dev.yonk.frontend.models.EmployeeModel;
import dev.yonk.frontend.models.ProductModel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "controls")
public class ControllerServlet extends HttpServlet {
    @Inject
    EmployeeModel em;
    @Inject
    ProductModel pm;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if(actionObject != null){
                String action = actionObject.toString();
                switch (action) {
                    case "emp_list":
                        em.getEmployeeList(req,resp);
                    case "product_list":
                        pm.getProductList(req,resp);
                    case "delete_emp":
                        em.deleteEmployee(req,resp);
                    case "delete_product":
                        pm.deleteProduct(req, resp);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if(actionObject != null){
                String action = actionObject.toString();
                switch (action) {
                    case "emp_add":
                        em.addEmployee(req,resp);
                        resp.sendRedirect("index.jsp");

                    case "product_add":
                        pm.addProduct(req,resp);
                        resp.sendRedirect("index.jsp");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
