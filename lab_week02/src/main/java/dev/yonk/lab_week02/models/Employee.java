package dev.yonk.lab_week02.models;

import dev.yonk.lab_week02.utils.EmployeeStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "nvarchar(255)", nullable = false)
    private String id;

    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(name = "dob", columnDefinition = "datetime", nullable = false)
    private LocalDate dob;
    @Column(name = "email", columnDefinition = "nvarchar(255)", nullable = false)
    private String email;
    @Column(name = "phone", columnDefinition = "nvarchar(255)", nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "nvarchar(255)", nullable = false)
    private String address;
    @Column(name = "status")
    private EmployeeStatus status;

    @OneToMany
    private List<Order> lstOrder;

    public Employee(String id, String name, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
