package com.testcase.one.Controller;

import com.testcase.one.Model.Billing;
import com.testcase.one.Model.Medicine_Info;
import com.testcase.one.Model.Product;
import com.testcase.one.Model.Supplier_Info;
import com.testcase.one.Service.MedicineService;
import com.testcase.one.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class MedicineController {

    @Autowired
    UserService userService;

    @Autowired
    MedicineService medicineService;


    //-----------------MEDICINES-----------------------//

    @RequestMapping(value = "/medicines/medicineList", method = RequestMethod.GET)
    public List<Medicine_Info> displayMedicineList(HttpServletRequest request) {
        return medicineService.getMedicinesList();
    }

    @PostMapping("/medicines/add")
    public Medicine_Info addMedicine(@RequestParam("companyName") String companyName, @RequestParam("medicineName") String medicineName, @RequestParam("price") int price,@RequestParam("availability") int availability )  {
        Medicine_Info medicine = new Medicine_Info(companyName,medicineName,price,availability);
        medicineService.addMedicine( medicine);
        return medicineService.findByMedicineId(medicine.getMedicineId());
    }

    @PostMapping("/medicine/update")
    public Medicine_Info updateMedicine(@RequestParam("medicineId") Integer medicineId,@RequestParam("companyName") String companyName, @RequestParam("medicineName") String medicineName, @RequestParam("price") int price,@RequestParam("availability") int availability )  {
        Medicine_Info medicine  =  medicineService.findByMedicineId(medicineId);
        medicine.setMedicineName(medicineName);
        medicine.setCompanyName(companyName);
        medicine.setPrice(price);
        medicine.setAvailability(availability);
        return medicineService.findByMedicineId(medicineId);
    }

    @PostMapping("/medicine/remove")
    @ResponseBody
    public void removeMedicine(@RequestParam("medicineId") Integer medicineId)  {
        medicineService.removeMedicine(medicineId);
    }

    //-----------------SUPPLIERS-----------------------//

    @RequestMapping(value = "/supplierList", method = RequestMethod.GET)
    public List<Supplier_Info> displaySuppliersList(HttpServletRequest request) {
        return medicineService.getSuppliersList();
    }

    @PostMapping("/suppliers/add")
    public Supplier_Info addSupplier(@RequestParam("supplierName") String supplierName, @RequestParam("email") String email, @RequestParam("mobileNumber") int mobileNumber)  {
        Supplier_Info supplier = new Supplier_Info(supplierName,mobileNumber,email);
        medicineService.addSupplier(supplier);
        return medicineService.findBySupplierId(supplier.getsupplierId());
    }

    @PostMapping("/supplier/update")
    public Supplier_Info updateMedicine(@RequestParam("supplierId") Integer supplierId,@RequestParam("supplierName") String supplierName, @RequestParam("email") String email, @RequestParam("mobileNumber") int mobileNumber)   {
        Supplier_Info supplier  =  medicineService.findBySupplierId(supplierId);
        supplier.setEmail(email);
        supplier.setMobileNumber(mobileNumber);
        supplier.setsupplierName(supplierName);
        return medicineService.findBySupplierId(supplierId);
    }

    @PostMapping("/supplier/remove")
    @ResponseBody
    public void removeSupplier(@RequestParam("supplierId") Integer supplierId)  {
        medicineService.removeSupplier(supplierId);
    }

    //--------------------BILLING------------------------//

    @PostMapping("/billing")
    public Billing addMedicine(@RequestParam("medicineName") String medicineName, @RequestParam("medicineId") int medicineId,@RequestParam("quantity") int quantity,@RequestParam("price") int price,@RequestParam("totalPrice") int totalPrice,@RequestParam("discount") int discount,@RequestParam("customerId") int customerId,@RequestParam("customerName") String customerName,@RequestParam("date") Date date )  {
        Billing billing = new Billing(medicineName,medicineId,quantity,price,totalPrice,discount,customerId, customerName, date);
        medicineService.addBilling( billing);
        return medicineService.findByBillingId(billing.getBillingId());
    }

    //-------------------SALES REPORT--------------------//
    @RequestMapping(value = "/salesReport", method = RequestMethod.GET)
    public List<Billing> displaySalesReport(HttpServletRequest request) {
        return medicineService.getSalesReport();
    }














}