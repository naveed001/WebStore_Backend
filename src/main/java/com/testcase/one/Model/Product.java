package com.testcase.one.Model;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    @Column(unique = true)
    private String productName;
    private double price;
    private String category;

    public Product(String productName, double price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String productname, Double price, Integer category) {
    }

    public Product(Integer productid, String productname, Double price, String category) {
        this.productid=productid;
        this.productName=productname;
        this.price=price;
        this.category=category;
    }

    public Product() {
    }
}
