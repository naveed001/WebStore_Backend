package com.testcase.one.DAO;

import com.testcase.one.Model.Medicine_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesDAO extends JpaRepository<Medicine_Info, Integer> {
    Medicine_Info findByMedicineId(int id);
    void deleteByMedicineId(int id);
}