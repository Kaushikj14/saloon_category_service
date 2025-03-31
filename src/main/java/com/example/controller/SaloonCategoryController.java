package com.example.controller;

import com.example.dto.SaloonDTO;
import com.example.modal.Category;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories/saloon-owner")
@RequiredArgsConstructor
public class SaloonCategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        Category category1 = categoryService.saveCategory(category,saloonDTO);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        categoryService.deleteCategoryById(id, saloonDTO.getId());
        return ResponseEntity.ok("category deleted successfully");
    }


}
