package com.campudual.appamazing.service;


import com.campudual.appamazing.api.IProductService;
import com.campudual.appamazing.model.Product;
import com.campudual.appamazing.model.dao.ProductDao;
import com.campudual.appamazing.model.dto.ProductDto;
import com.campudual.appamazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
@Lazy
public class ProductService implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDto queryProduct(ProductDto productDTO) {

        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        Product finalProduct = this.productDao.getReferenceById(product.getStock());
        return ProductMapper.INSTANCE.toDTO(finalProduct);
    }

    @Override
    public List<ProductDto> queryAllProducts() {
        return ProductMapper.INSTANCE.toDTOList(this.productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDto productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO); //genera un nuevo producto sin id
        Product product1 = this.productDao.saveAndFlush(product); // cuando se guarda en la  BD y devuelve un id
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDto productDTO) {
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDto productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productDao.delete(product);
        return id;
    }
}
