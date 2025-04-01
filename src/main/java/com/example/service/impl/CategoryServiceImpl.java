package com.example.service.impl;

import com.example.dto.SaloonDTO;
import com.example.modal.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SaloonDTO saloonDTO) {

        Category newCategory = new Category();

        newCategory.setId(category.getId());
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());
        newCategory.setSaloonId(saloonDTO.getId());
//        newCategory.setSaloonId(category.getSaloonId());

        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySaloon(Long id) {
        return  categoryRepository.findBySaloonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category==null){
            throw new Exception("category not exists by id");
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id,Long saloonId) throws Exception {
        Category category = getCategoryById(id);

        if (category.getSaloonId() == null) {
            throw new Exception("Category has no associated saloonId, cannot delete.");
        }


        if (!category.getSaloonId().equals(saloonId)){
            throw new Exception("you doen't have permission to delete this category");
        }
        categoryRepository.deleteById(id);
    }
}
