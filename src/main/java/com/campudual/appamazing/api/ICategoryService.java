package com.campudual.appamazing.api;

import com.campudual.appamazing.model.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    CategoryDto queryCategory(CategoryDto categoryDto);
    List<CategoryDto> queryAllCategory();
    int insertCategory(CategoryDto categoryDto);
    int updateCategory(CategoryDto categoryDto);
    int deleteCategory(CategoryDto categoryDto);

}
