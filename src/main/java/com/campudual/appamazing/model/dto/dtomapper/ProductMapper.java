package com.campudual.appamazing.model.dto.dtomapper;

import com.campudual.appamazing.model.Product;
import com.campudual.appamazing.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDTO(Product product);
    List<ProductDto> toDTOList(List<Product> products);
    Product toEntity(ProductDto productDto);


}
