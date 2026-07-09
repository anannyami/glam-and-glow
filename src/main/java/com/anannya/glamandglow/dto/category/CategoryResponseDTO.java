package com.anannya.glamandglow.dto.category;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private Boolean active;
    private Integer displayOrder;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
