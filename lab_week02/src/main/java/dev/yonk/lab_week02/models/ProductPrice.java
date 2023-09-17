package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

@Entity
@Table(name = "prouct_price")
public class ProductPrice {

    @EmbeddedId
    private ProductPriceId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private Double price;

    @Column(name = "note")
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(ProductPriceId id, Product product, Double price, String note) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.note = note;
    }

    public ProductPriceId getId() {
        return id;
    }

    public void setId(ProductPriceId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
