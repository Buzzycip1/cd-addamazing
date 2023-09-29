package com.campudual.appamazing.service;

import com.campudual.appamazing.api.ICategoryService;
import com.campudual.appamazing.model.Category;
import com.campudual.appamazing.model.dao.CategoryDao;
import com.campudual.appamazing.model.dto.CategoryDto;
import com.campudual.appamazing.model.dto.dtomapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Lazy
@Service("CategoryService")
public class CategoryService implements ICategoryService {

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
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO); //genera una nueva categoria  sin id
        Category category1 = this.categoryDao.saveAndFlush(category); // cuando se guarda en la  BD y devuelve un id
        return category.getId();
    }

    @Override
    public int updateCategory(CategoryDto categoryDTO) {
        return this.insertCategory(categoryDTO);
    }

    @Override
    public int deleteCategory(CategoryDto categoryDTO) {
        int id = categoryDTO.getId();
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        categoryDao.delete(category);
        return id;
    }
}
