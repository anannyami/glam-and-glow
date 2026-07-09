package com.anannya.glamandglow.mapper;

import com.anannya.glamandglow.dto.category.CategoryRequestDTO;
import com.anannya.glamandglow.dto.category.CategoryResponseDTO;
import com.anannya.glamandglow.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO request) {
        if (request == null) {
            return null;
        }

        return Category.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .description(request.getDescription())
                .active(request.getActive() != null ? request.getActive() : true)
                .displayOrder(request.getDisplayOrder() != null ? request.getDisplayOrder() : 0)
                .imageUrl(request.getImageUrl())
                .build();
    }

    public CategoryResponseDTO toResponseDTO(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .active(category.getActive())
                .displayOrder(category.getDisplayOrder())
                .imageUrl(category.getImageUrl())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}
