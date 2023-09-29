package com.campudual.appamazing.controller;


import com.campudual.appamazing.api.ICategoryService;
import com.campudual.appamazing.model.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private ICategoryService categoryService;

    @GetMapping(value = "/testMethod")
    public String testControllerMethod() {
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public CategoryDto queryCategory(@RequestBody CategoryDto category) {
        return this.categoryService.queryCategory(category);
    }

    @GetMapping(value = "/getAll")
    public List<CategoryDto> queryAllCategory() {
        return this.categoryService.queryAllCategory();
    }

    @PostMapping(value = "/add")
    public int insertCategory(@RequestBody CategoryDto category) {
        return this.categoryService.insertCategory(category);
    }

    @PutMapping(value = "/update")
    public int updateCategories(@RequestBody CategoryDto category) {
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "/delete")
    public int deleteCategory(@RequestBody CategoryDto category) {
        return this.categoryService.deleteCategory(category);

    }


}

