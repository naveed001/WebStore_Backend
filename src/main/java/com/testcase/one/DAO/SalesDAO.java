package com.testcase.one.DAO;

import com.testcase.one.Model.Sales_Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDAO extends JpaRepository<Sales_Report, Integer> {

}