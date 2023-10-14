package com.chijioke.mazeproperty.service;

import com.chijioke.mazeproperty.model.Product;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

    List<Product> productList =null;


    @PostConstruct
    public  void loadProductDummy() {

        productList = LongStream.rangeClosed(1, 100)
                .mapToObj(i -> Product.builder()
                        .id(i)
                        .name("product" + i)
                        .price(new Random().nextFloat(5000)).build()
                ).collect(Collectors.toList());
    }
    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProduct(Long productId) {
        return productList.stream()
                .filter(product -> product.getId().equals(productId))
                .findAny()
                .orElseThrow(()-> new RuntimeException("product not found"));
    }
}
