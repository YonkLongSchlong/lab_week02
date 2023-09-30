package dev.yonk.backend.models;

import dev.yonk.backend.enums.ProductStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status = 1")
)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "nvarchar(255)")
    private String description;
    @Column(name = "unit", nullable = false, columnDefinition = "nvarchar(255)")
    private String unit;
    @Column(name = "manufacturer_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String manufacturer;

    @Enumerated
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> lstOrderDetail;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> lstProductPrice;

    @OneToMany(mappedBy = "product")
    private List<ProductImg> lstProductImg;

    public Product() {
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }
    public Product(String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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


    public List<OrderDetail> getLstOrderDetail() {
        return lstOrderDetail;
    }

    public void setLstOrderDetail(List<OrderDetail> lstOrderDetail) {
        this.lstOrderDetail = lstOrderDetail;
    }

    public List<ProductPrice> getLstProductPrice() {
        return lstProductPrice;
    }

    public void setLstProductPrice(List<ProductPrice> lstProductPrice) {
        this.lstProductPrice = lstProductPrice;
    }

    public List<ProductImg> getLstProductImg() {
        return lstProductImg;
    }

    public void setLstProductImg(List<ProductImg> lstProductImg) {
        this.lstProductImg = lstProductImg;
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
