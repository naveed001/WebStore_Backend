package com.testcase.one.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "suppliers_info")
public class Supplier_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    private String supplierName;

    private int mobileNumber;

    @Email(message = "*Please provide a valid Email")
    private String email;

    public int getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getsupplierName() {
        return supplierName;
    }

    public void setsupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Supplier_Info(String supplierName, int mobileNumber, @Email(message = "*Please provide a valid Email") String email) {
        this.supplierName = supplierName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}
