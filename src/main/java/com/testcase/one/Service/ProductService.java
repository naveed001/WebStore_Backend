package com.testcase.one.Service;

import com.testcase.one.DAO.ProductDAO;
import com.testcase.one.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List getProductList()
    {
        return productDAO.findAll();
    }

    public void addProduct(Product product)
    {
        productDAO.save(product);
    }

    public Product findById(int productId) {
        Optional<Product> product = productDAO.findById(productId);
       return product.get();
    }

    public void removeProduct(int pid){
        productDAO.deleteById(pid);
    }

    public Product findByName(String productname) {
        return productDAO.findProductByProductName(productname);
    }

}