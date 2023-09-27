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
        Product productFinal = this.productDao.getReferenceById(product.getId());
        return ProductMapper.INSTANCE.toDTO(productFinal);

    }

    @Override
    public List<ProductDto> queryAllProducts() {
       return ProductMapper.INSTANCE.toDTOList(this.productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDto productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        this.productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDto product) {
        return 0;
    }

    @Override
    public int deleteProduct(ProductDto product) {
        return 0;
    }
}
