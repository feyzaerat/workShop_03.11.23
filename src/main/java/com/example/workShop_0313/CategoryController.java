package com.example.workShop_0313;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    List<Category> categoryModel = new ArrayList<>();

    @GetMapping
    public List<Category> getAll() {
        return categoryModel;
    }


    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {
        Category getCategory = categoryModel.stream()
                .filter((gCategory) -> gCategory.getId() == id)
                .findFirst().orElseThrow();
        return getCategory;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryModel.add(category);
    }

    @PutMapping
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category putCategory = categoryModel.stream()
                .filter((uCategory) -> uCategory.getId() == id)
                .findFirst().orElseThrow();
        putCategory.setId(category.getId());
        putCategory.setCategoryName(category.getCategoryName());
        putCategory.setSubCategoryName(category.getSubCategoryName());
        putCategory.setCreatedAt(category.getCreatedAt());
        putCategory.setUpdatedAt(category.getUpdatedAt());
        putCategory.setUpdatedById(category.getUpdatedById());
        putCategory.setIsActive(category.getIsActive());
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable int id) {
        Category dropCategory = categoryModel.stream()
                .filter((dCategory) -> dCategory.getId() == id)
                .findFirst().orElseThrow();
        categoryModel.remove(dropCategory);
    }
}
