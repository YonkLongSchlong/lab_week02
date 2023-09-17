package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String id;

    @Column(name = "order_date", nullable = false, columnDefinition = "datetime")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn
    private Employee employeeId;
    @ManyToOne
    @JoinColumn
    private Customer customerId;
}
