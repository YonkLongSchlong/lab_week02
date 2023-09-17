package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String id;

    @Column(name = "order_date", nullable = false, columnDefinition = "datetime")
    private LocalDate orderDate;


    @OneToMany(mappedBy = "order")
    private List<OrderDetail> lstOrderDetail;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    public Order() {
    }

    public Order(String id, LocalDate orderDate, List<OrderDetail> lstOrderDetail, Employee employee, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.lstOrderDetail = lstOrderDetail;
        this.employee = employee;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getLstOrderDetail() {
        return lstOrderDetail;
    }

    public void setLstOrderDetail(List<OrderDetail> lstOrderDetail) {
        this.lstOrderDetail = lstOrderDetail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderDate=" + orderDate +
                ", lstOrderDetail=" + lstOrderDetail +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
