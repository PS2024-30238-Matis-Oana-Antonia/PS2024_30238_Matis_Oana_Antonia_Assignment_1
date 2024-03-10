package com.example.carturestibackend.controllers;

import com.example.carturestibackend.services.CategoryService;
import com.example.carturestibackend.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller class to handle HTTP requests related to categories.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * Constructs a new CategoryController with the specified CategoryService.
     *
     * @param categoryService The CategoryService used to handle category-related business logic.
     */
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Retrieves all categories.
     *
     * @return A ResponseEntity containing a list of CategoryDTO objects representing the categories.
     */
    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> dtos = categoryService.findCategories();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Inserts a new category.
     *
     * @param categoryDTO The CategoryDTO object representing the category to insert.
     * @return A ResponseEntity containing the ID of the newly inserted category.
     */
    @PostMapping()
    public ResponseEntity<Long> insertCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        long categoryID = categoryService.insert(categoryDTO);
        return new ResponseEntity<>(categoryID, HttpStatus.CREATED);
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param categoryID The ID of the category to retrieve.
     * @return A ResponseEntity containing the CategoryDTO object representing the retrieved category.
     */
    @GetMapping(value = "/{id_category}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id_category") long categoryID) {
        CategoryDTO dto = categoryService.findCategoryById(categoryID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param categoryID The ID of the category to delete.
     * @return A ResponseEntity indicating the success of the operation.
     */
    @DeleteMapping(value = "/{id_category}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id_category") long categoryID) {
        categoryService.deleteCategoryById(categoryID);
        return new ResponseEntity<>("Category with ID " + categoryID + " deleted successfully", HttpStatus.OK);
    }

    /**
     * Updates a category by its ID.
     *
     * @param categoryID    The ID of the category to update.
     * @param categoryDTO   The updated CategoryDTO object representing the new state of the category.
     * @return A ResponseEntity containing the updated CategoryDTO object.
     */
    @PutMapping(value = "/{id_category}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id_category") long categoryID, @Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryID, categoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
