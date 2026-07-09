package com.anannya.glamandglow.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDTO {

    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Category slug is required")
    @Size(max = 100, message = "Category slug must not exceed 100 characters")
    private String slug;

    @Size(max = 1000, message = "Category description must not exceed 1000 characters")
    private String description;

    private Boolean active;

    private Integer displayOrder;

    @Size(max = 500, message = "Category image URL must not exceed 500 characters")
    private String imageUrl;
}
