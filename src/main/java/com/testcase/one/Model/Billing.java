package com.testcase.one.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billingId;

    private String medicineName;

    private int medicineId;

    private int quantity;

    private int price;

    private int totalPrice;

    private int discount;

    private int customerId;

    private String customerName;

    @DateTimeFormat
    private Date date;

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Billing(String medicineName, int medicineId, int quantity, int price, int totalPrice, int discount, int customerId, String customerName, Date date) {
        this.medicineName = medicineName;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
    }
}
