package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.CategoryDTO;
import com.example.carturestibackend.dtos.builders.CategoryBuilder;
import com.example.carturestibackend.entities.Category;
import com.example.carturestibackend.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryBuilder::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findCategoryById(long id_category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id_category);
        if (!categoryOptional.isPresent()) {
            LOGGER.error("Category with id {} was not found in db", id_category);
            throw new ResourceNotFoundException(Category.class.getSimpleName() + " with id: " + id_category);
        }
        return CategoryBuilder.toCategoryDTO(categoryOptional.get());
    }

    public long insert(CategoryDTO categoryDTO) {
        Category category = CategoryBuilder.fromCategoryDTO(categoryDTO);
        category = categoryRepository.save(category);
        LOGGER.debug("Category with id {} was inserted in db", category.getId_category());
        return category.getId_category();
    }

    public void deleteCategoryById(long id_category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id_category);
        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
        } else {
            throw new ResourceNotFoundException(Category.class.getSimpleName() + " with id: " + id_category);
        }
    }

    public CategoryDTO updateCategory(long id_category, CategoryDTO categoryDTO) {
        Optional<Category> categoryOptional = categoryRepository.findById(id_category);
        if (!categoryOptional.isPresent()) {
            LOGGER.error("Category with id {} was not found in db", id_category);
            throw new ResourceNotFoundException(Category.class.getSimpleName() + " with id: " + id_category);
        }

        Category existingCategory = categoryOptional.get();
        existingCategory.setName(categoryDTO.getName());
        existingCategory.setDescription(categoryDTO.getDescription());

        Category updatedCategory = categoryRepository.save(existingCategory);
        LOGGER.debug("Category with id {} was updated in db", updatedCategory.getId_category());

        return CategoryBuilder.toCategoryDTO(updatedCategory);
    }
}
