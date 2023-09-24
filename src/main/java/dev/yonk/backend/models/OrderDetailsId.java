package dev.yonk.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailsId implements Serializable {
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Column(name = "order_id", nullable = false)
    private long orderId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(long productId, long orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsId that = (OrderDetailsId) o;
        return productId == that.productId && orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }

    @Override
    public String toString() {
        return "OrderDetailsId{" +
                "productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
