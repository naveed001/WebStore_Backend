package com.testcase.one.DAO;

import com.testcase.one.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDAO extends JpaRepository<Billing, Integer> {
    Billing findByBillingId(int id);
}