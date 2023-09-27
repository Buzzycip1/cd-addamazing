package com.campudual.appamazing.api;

import com.campudual.appamazing.model.dto.ProductDto;

import java.util.List;

public interface IProductService {


    ProductDto queryProduct (ProductDto product);
    List<ProductDto> queryAllProducts();
    int insertProduct (ProductDto product);
    int updateProduct (ProductDto product);
    int deleteProduct (ProductDto product);


}

