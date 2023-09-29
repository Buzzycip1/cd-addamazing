package com.campudual.appamazing.service;

import com.campudual.appamazing.model.Category;
import com.campudual.appamazing.model.dao.CategoryDao;
import com.campudual.appamazing.model.dto.CategoryDto;
import com.campudual.appamazing.model.dto.dtomapper.CategoryMapper;
import com.campudual.appamazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryDto queryCategory(CategoryDto categoryDTO) {

        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        Category finalCategory = this.categoryDao.getReferenceById(category.getId());
        return CategoryMapper.INSTANCE.toDTO(finalCategory);
    }

    @Override
    public List<CategoryDto> queryAllCategory() {
        return CategoryMapper.INSTANCE.toDTOList(this.categoryDao.findAll());
    }

    @Override
    public int insertCategory(CategoryDto categoryDTO) {
        Category category = ContactMapper.INSTANCE.toEntity(categoryDTO); //genera un nuevo contacto  sin id
        Category category1contact1 = this.categoryDao.saveAndFlush(category); // cuando se guarda en la  BD y devuelve un id
        return category.getId();
    }

    @Override
    public int updateCategory(CategoryDto categoryDTO) {
        return this.insertCategory(categoryDTO);
    }

    @Override
    public int deleteCategory(CategoryDto categoryDTO) {
        int id = categoryDTO.getId();
        Category category = ContactMapper.INSTANCE.toEntity(categoryDTO);
        categoryDao.delete(category);
        return id;
    }
}
