package dev.yonk.lab_week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ProductPriceId implements Serializable {

    @Column(name = "product_id", nullable = false)
    private long productId;

    @Column(name = "price_date_time", nullable = false)
    private LocalDate priceDateTime;

    public ProductPriceId() {
    }

    public ProductPriceId(long productId, LocalDate priceDateTime) {
        this.productId = productId;
        this.priceDateTime = priceDateTime;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public LocalDate getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDate priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceId that = (ProductPriceId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(priceDateTime, that.priceDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, priceDateTime);
    }

    @Override
    public String toString() {
        return "ProductPriceId{" +
                "productId='" + productId + '\'' +
                ", priceDateTime=" + priceDateTime +
                '}';
    }
}
