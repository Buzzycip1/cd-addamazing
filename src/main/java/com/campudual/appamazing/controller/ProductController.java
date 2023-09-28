package com.campudual.appamazing.controller;


import com.campudual.appamazing.api.IProductService;
import com.campudual.appamazing.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    IProductService productService;

        @GetMapping
        public String testController(){
            return "Product controller works!";
        }
    @PostMapping
    public String testController(@RequestBody String name){
        return "Product controller works, " + name + "!";
    }
    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public ProductDto queryProduct(ProductDto product){
            return this.productService.queryProduct(product);
    }

}
