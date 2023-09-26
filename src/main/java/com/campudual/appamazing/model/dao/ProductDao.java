package com.campudual.appamazing.model.dao;

import com.campudual.appamazing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {



}
