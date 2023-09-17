package dev.yonk.lab_week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsId that = (OrderDetailsId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }

    @Override
    public String toString() {
        return "OrderDetailsId{" +
                "productId='" + productId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
