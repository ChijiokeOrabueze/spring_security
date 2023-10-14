package com.chijioke.mazeproperty.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@Data
public class Product {

    private Long id;

    private String name;

    private Float price;

}
