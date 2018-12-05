package com.popovich.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private String productName;
    private String productCategory;
    private Integer cost;

    public Product() {
    }

    public Product(String productName, String productCategory, Integer cost) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "product_name", nullable = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_category", nullable = false)
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Column(name = "cost", nullable = false)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductDao{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", cost=" + cost +
                '}';
    }
}
