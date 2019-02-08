package com.testcase.one.Controller;

import com.testcase.one.DAO.ProductDAOFilter;
import com.testcase.one.Model.Product;
import com.testcase.one.Model.User;
import com.testcase.one.Service.CartItemService;
import com.testcase.one.Service.ProductService;
import com.testcase.one.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductDAOFilter productDAOFilter;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    UserService userService;
    User user;


    @RequestMapping(value = "/product/productlist", method = RequestMethod.GET)
    public List<Product> displayProductList(HttpServletRequest request) {//        String username = (String) ((SecurityContext)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal();
//        System.out.println(username);
        return productService.getProductList();
    }

    @RequestMapping(value = "/product/byid", method = RequestMethod.GET)
    public Product displayProductListById(@RequestParam("productid") Integer productid) {
        return productService.findById(productid);
    }


    @RequestMapping(value = "/product/byname", method = RequestMethod.GET)
    public Product displayProductListByName(@RequestParam("productname") String productname) {
        return productService.findByName(productname);
    }

    @RequestMapping(value = "/product/bynamelike", method = RequestMethod.GET)
    public List<Product> findProductsByNameLike(@RequestParam("namelike") String namelike )
    {
        List<Product> list = productDAOFilter.findProductsByProductNameLike(namelike);
        return list;
    }

    @RequestMapping(value = "/product/bycategory", method = RequestMethod.GET)
    public List<Product> displayProductListByCategory(@RequestParam("category") String category)
    {
        List<Product> list = productDAOFilter.findProductsByCategory(category);
        return list;
    }

    @RequestMapping(value = "/product/byPrice", method = RequestMethod.GET)
    public List<Product> displayProductListByCategory(@RequestParam("minprice") Double minprice, @RequestParam("maxprice") Double maxprice, @RequestParam("category") String category)
    {
            List<Product> list = productDAOFilter.findAllByPriceBetweenAndCategory(minprice, maxprice, category);
            return list;
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestParam("productname") String productname,@RequestParam("price") Double price,@RequestParam("category") String category)  {
        Product product = new Product(productname,price,category);
        productService.addProduct( product);
        return productService.findById(product.getProductid());
 }

    @PostMapping("/product/update")
    public Product updateProduct(@RequestParam("productid") Integer productid,@RequestParam("productname") String productname,@RequestParam("price") Double price,@RequestParam("category") String category)  {
       Product product =  productService.findById(productid);
       product.setProductName(productname);
       product.setPrice(price);
       product.setCategory(category);
       productService.addProduct( product);
       return productService.findById(productid);
    }

    @PostMapping("/product/remove")
    @ResponseBody
    public void removeProduct(@RequestParam("productid") Integer productid)  {
        productService.removeProduct(productid);
    }

}