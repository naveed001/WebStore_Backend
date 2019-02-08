package com.testcase.one.DAO;

import com.testcase.one.Model.PlacedOrder;
import com.testcase.one.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository <PlacedOrder,Integer > {

    List<PlacedOrder> findByUser(User user);
}
