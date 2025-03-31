package com.example.service;

import com.example.dto.SaloonDTO;
import com.example.modal.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SaloonDTO saloonDTO);
    Set<Category> getAllCategoriesBySaloon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id,Long saloonId) throws Exception;

}
