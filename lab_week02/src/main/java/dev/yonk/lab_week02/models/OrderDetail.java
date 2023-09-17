package dev.yonk.lab_week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailsId id;

    private int quantity;

    
    private BigDecimal price;

    private String note;
}
