package dev.yonk.lab_week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class ProductPriceId {

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "local_date_time", nullable = false)
    private LocalDate priceDateTime;

    public ProductPriceId() {
    }

    public ProductPriceId(String productId, LocalDate priceDateTime) {
        this.productId = productId;
        this.priceDateTime = priceDateTime;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDate getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDate priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    @Override
    public String toString() {
        return "ProductPriceId{" +
                "productId='" + productId + '\'' +
                ", priceDateTime=" + priceDateTime +
                '}';
    }
}
