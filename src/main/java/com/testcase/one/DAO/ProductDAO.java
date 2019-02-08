package com.testcase.one.DAO;

import com.testcase.one.Model.Product;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

     Product findProductByProductName(String productname);

//      @Query(value = "update product set product_name = ?2 , price=?3,category=?4 where productid=?1", nativeQuery = true)
//      void updateProductsById(int productid, String productname, double price, String category);

}
