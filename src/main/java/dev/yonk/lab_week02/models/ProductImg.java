package dev.yonk.lab_week02.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "product_image")
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private long imageId;

    @Column(name = "alternative")
    private String alternative;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImg() {
    }

    public ProductImg(long imageId, String alternative, String path, Product product) {
        this.imageId = imageId;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImg{" +
                "imageId=" + imageId +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}
