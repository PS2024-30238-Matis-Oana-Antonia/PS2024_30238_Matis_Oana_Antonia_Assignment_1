package com.example.carturestibackend.controllers;

import com.example.carturestibackend.services.CategoryService;
import com.example.carturestibackend.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> dtos = categoryService.findCategories();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        long categoryID = categoryService.insert(categoryDTO);
        return new ResponseEntity<>(categoryID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id_category}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id_category") long categoryID) {
        CategoryDTO dto = categoryService.findCategoryById(categoryID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_category}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id_category") long categoryID) {
        categoryService.deleteCategoryById(categoryID);
        return new ResponseEntity<>("Category with ID " + categoryID + " deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_category}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id_category") long categoryID, @Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryID, categoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
