package dev.yonk.lab_week02.models;

import dev.yonk.lab_week02.utils.ProductStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String id;
    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "nvarchar(255)")
    private String description;
    @Column(name = "unit", nullable = false, columnDefinition = "nvarchar(255)")
    private String unit;
    @Column(name = "manufacturer_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String manufacturer;
    @Column(name = "unit", nullable = false)
    private ProductStatus status;

    public Product() {
    }

    public Product(String id, String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                '}';
    }
}
