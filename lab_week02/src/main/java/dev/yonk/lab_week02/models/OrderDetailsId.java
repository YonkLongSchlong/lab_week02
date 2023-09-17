package dev.yonk.lab_week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailsId implements Serializable {
    @Column(name = "product_id", nullable = false)
    private String productId;
    @Column(name = "order_id", nullable = false)
    private String orderId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(String productId, String orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailsId{" +
                "productId='" + productId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
