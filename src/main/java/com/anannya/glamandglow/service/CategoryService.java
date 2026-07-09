package com.anannya.glamandglow.service;

import com.anannya.glamandglow.dto.category.CategoryRequestDTO;
import com.anannya.glamandglow.dto.category.CategoryResponseDTO;
import com.anannya.glamandglow.entity.Category;
import com.anannya.glamandglow.exception.category.CategoryAlreadyExistsException;
import com.anannya.glamandglow.exception.category.CategoryNotFoundException;
import com.anannya.glamandglow.mapper.CategoryMapper;
import com.anannya.glamandglow.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        validateCategoryRequest(request);

        if (categoryRepository.existsBySlug(request.getSlug().trim())) {
            throw new CategoryAlreadyExistsException("Category slug already exists: " + request.getSlug());
        }

        if (categoryRepository.findAll().stream()
                .anyMatch(category -> category.getName().equalsIgnoreCase(request.getName().trim()))) {
            throw new CategoryAlreadyExistsException("Category name already exists: " + request.getName());
        }

        Category category = categoryMapper.toEntity(request);
        Category savedCategory = categoryRepository.save(category);

        log.info("Created category with slug: {}", savedCategory.getSlug());
        return categoryMapper.toResponseDTO(savedCategory);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        return categoryMapper.toResponseDTO(category);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO getCategoryBySlug(String slug) {
        Category category = categoryRepository.findBySlug(slug)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with slug: " + slug));
        return categoryMapper.toResponseDTO(category);
    }

    @Transactional(readOnly = true)
    public Page<CategoryResponseDTO> getAllCategories(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        List<CategoryResponseDTO> content = categoryPage.getContent()
                .stream()
                .map(categoryMapper::toResponseDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(content, pageable, categoryPage.getTotalElements());
    }

    @Transactional
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO request) {
        validateCategoryRequest(request);

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

        if (!existingCategory.getSlug().equalsIgnoreCase(request.getSlug().trim())
                && categoryRepository.existsBySlug(request.getSlug().trim())) {
            throw new CategoryAlreadyExistsException("Category slug already exists: " + request.getSlug());
        }

        if (!existingCategory.getName().equalsIgnoreCase(request.getName().trim())
                && categoryRepository.findAll().stream()
                        .anyMatch(category -> category.getId() != null
                                && !category.getId().equals(existingCategory.getId())
                                && category.getName().equalsIgnoreCase(request.getName().trim()))) {
            throw new CategoryAlreadyExistsException("Category name already exists: " + request.getName());
        }

        existingCategory.setName(request.getName().trim());
        existingCategory.setSlug(request.getSlug().trim());
        existingCategory.setDescription(request.getDescription());
        existingCategory.setActive(request.getActive() != null ? request.getActive() : true);
        existingCategory.setDisplayOrder(request.getDisplayOrder() != null ? request.getDisplayOrder() : 0);
        existingCategory.setImageUrl(request.getImageUrl());

        Category updatedCategory = categoryRepository.save(existingCategory);
        log.info("Updated category with id: {}", updatedCategory.getId());
        return categoryMapper.toResponseDTO(updatedCategory);
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

        categoryRepository.delete(category);
        log.info("Deleted category with id: {}", id);
    }

    private void validateCategoryRequest(CategoryRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Category request cannot be null");
        }

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name is required");
        }

        if (request.getSlug() == null || request.getSlug().trim().isEmpty()) {
            throw new IllegalArgumentException("Category slug is required");
        }
    }
}
