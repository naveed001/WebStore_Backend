package com.testcase.one.Service;

import com.testcase.one.DAO.*;
import com.testcase.one.Model.Billing;
import com.testcase.one.Model.Medicine_Info;
import com.testcase.one.Model.Product;
import com.testcase.one.Model.Supplier_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MedicinesDAO medicinesDAO;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private SalesDAO salesDAO;

    @Autowired
    private BillingDAO billingDAO;

    public List getMedicinesList()
    {
        return medicinesDAO.findAll();
    }

    public void addMedicine(Medicine_Info medicine)
    {
        medicinesDAO.save(medicine);
    }

    public List getSuppliersList()
    {
        return supplierDAO.findAll();
    }

    public void addSupplier(Supplier_Info supplier)
    {
        supplierDAO.save(supplier);
    }

    public List getSalesReport()
    {
        return billingDAO.findAll();
    }

    public void addBilling(Billing billing)
    {
        billingDAO.save(billing);
    }

    public Medicine_Info findByMedicineId(int medicineId){
       return  medicinesDAO.findByMedicineId(medicineId);
    }

    public Supplier_Info findBySupplierId(int supplierId){
       return supplierDAO.findBySupplierId(supplierId);
    }

    public Billing findByBillingId(int billingId){
        return billingDAO.findByBillingId(billingId);
    }

    public void removeMedicine(int medicineId){
        medicinesDAO.deleteByMedicineId(medicineId);
    }

    public void removeSupplier(int supplierId){
        supplierDAO.deleteBySupplierId(supplierId);
    }


}
