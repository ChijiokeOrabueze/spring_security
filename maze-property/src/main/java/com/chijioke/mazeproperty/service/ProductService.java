package com.chijioke.mazeproperty.service;

import com.chijioke.mazeproperty.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts ();

    Product getProduct (Long prouctId);
}
