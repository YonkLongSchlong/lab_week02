package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "product_image")
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private BigInteger imageId;

    @Column(name = "alternative")
    private String alternative;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
