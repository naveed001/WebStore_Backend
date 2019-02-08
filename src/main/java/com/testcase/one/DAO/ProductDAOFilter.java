package com.testcase.one.DAO;

import com.testcase.one.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAOFilter extends JpaRepository<Product, Integer> {

    List<Product> findProductsByCategory(String category);

    @Query(value = "select * from caseStudy.product where product_name like %?1%",nativeQuery = true)
    List<Product> findProductsByProductNameLike(@Param("namelike")String namelike);

    List<Product> findAllByPriceBetweenAndCategory(double p1,double p2,String category);
}
