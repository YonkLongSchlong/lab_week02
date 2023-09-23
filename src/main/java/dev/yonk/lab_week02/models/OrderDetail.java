package dev.yonk.lab_week02.models;

import jakarta.persistence.*;


@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailsId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "note")
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailsId id, int quantity, double price, String note) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public OrderDetailsId getId() {
        return id;
    }

    public void setId(OrderDetailsId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
