package com.campudual.appamazing.model.dao;

import com.campudual.appamazing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao  extends JpaRepository<Category, Integer> {
}
