package com.testcase.one.Model;


import javax.persistence.*;

@Entity
@Table(name = "medicine_info")
public class Medicine_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicineId;

    private String companyName;

    private String medicineName;

    private int price;

    private int availability;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Medicine_Info(String companyName, String medicineName, int price, int availability) {
        this.companyName = companyName;
        this.medicineName = medicineName;
        this.price = price;
        this.availability = availability;
    }
}
