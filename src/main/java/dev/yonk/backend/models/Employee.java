package dev.yonk.backend.models;

import dev.yonk.backend.enums.EmployeeStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status = 1")
)
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private long id;
    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    @Column(name = "email", columnDefinition = "nvarchar(255)", nullable = false)
    private String email;
    @Column(name = "phone", columnDefinition = "nvarchar(255)", nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "nvarchar(255)", nullable = false)
    private String address;

    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee")
    private List<Order> lstOrder;

    public Employee(long id, String name, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee(String name, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
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
