package com.campudual.appamazing.controller;


import com.campudual.appamazing.api.IProductService;
import com.campudual.appamazing.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String testController() {
        return "Product controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name) {
        return "Product controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod() {
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public ProductDto queryProduct(@RequestBody ProductDto product) {
        return this.productService.queryProduct(product);
    }

    @GetMapping(value = "/getAll")
    public List<ProductDto> queryAllProducts() {
        return this.productService.queryAllProducts();
    }

    @PostMapping(value = "/add")
    public int insertProduct(@RequestBody ProductDto product) {
        return this.productService.insertProduct(product);
    }

    @PutMapping(value = "/update")
    public int updateProduct(@RequestBody ProductDto product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping(value = "/delete")
    public int deleteProduct(@RequestBody ProductDto product) {
        return this.productService.deleteProduct(product);
    }

    @PutMapping(value= "/buy")
    public int buyProduct(@RequestBody ProductDto productDTO) {
        return this.productService.buyProduct(productDTO,5);
    }

//    @PutMapping(value = "/buy")
//    public int buyProduct(@RequestBody ProductDto productDTO) {
//        int quantity = 5;
//        return this.productService.buyProduct(productDTO, quantity);
//    }

    @PostMapping(value = "/buyandshowprice")
    public BigDecimal buyProductAndShowPrice(@RequestBody ProductDto productDTO){
        int quantity = 5;
        this.productService.calculateTotalPrice(productDTO, quantity);
        return this.productService.calculateTotalPrice(productDTO, quantity);
    }


}


