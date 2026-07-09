package com.anannya.glamandglow.dto;

import com.anannya.glamandglow.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
}