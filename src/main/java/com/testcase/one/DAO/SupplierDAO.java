package com.testcase.one.DAO;

import com.testcase.one.Model.Supplier_Info;
import com.testcase.one.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierDAO extends JpaRepository<Supplier_Info, Integer> {
    Supplier_Info findBySupplierId(int id);
    void deleteBySupplierId(int id);
}