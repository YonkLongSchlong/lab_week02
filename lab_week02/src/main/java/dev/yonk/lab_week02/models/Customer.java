package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String id;
    @Column(name = "cus_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "nvarchar(255)")
    private String email;
    @Column(name = "phone", nullable = false, columnDefinition = "nvarchar(255)")
    private String phone;
    @Column(name = "address", nullable = false, columnDefinition = "nvarchar(255)")
    private String address;

    @OneToMany(mappedBy = "customerId")
    private List<Order> lstOrder;

    public Customer() {
    }

    public Customer(String id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
