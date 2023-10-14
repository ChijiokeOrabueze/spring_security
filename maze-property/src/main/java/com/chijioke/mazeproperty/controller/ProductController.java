package com.chijioke.mazeproperty.controller;

import com.chijioke.mazeproperty.model.Product;
import com.chijioke.mazeproperty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts () {
        return productService.getAllProducts();
    }

    @GetMapping("/welcome")
    public String welcomeUser () {

        return "Welcome to my app";
    }

    @GetMapping("/{productId}")
    public Product getProduct (@PathVariable Long productId){

        return productService.getProduct(productId);
    }


}
