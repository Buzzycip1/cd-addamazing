package com.campudual.appamazing.api;

import com.campudual.appamazing.model.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {

    ProductDto queryProduct(ProductDto productDTO);

    List<ProductDto> queryAllProducts();

    int insertProduct(ProductDto productDTO);

    int updateProduct(ProductDto productDTO);

    int deleteProduct(ProductDto productDTO);

    int buyProduct(ProductDto productDTO, int quantity);

    BigDecimal calculateTotalPrice(ProductDto productDTO, int quantity);

}

