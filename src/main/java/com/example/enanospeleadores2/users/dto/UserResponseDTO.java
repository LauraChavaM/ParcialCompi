package com.example.enanospeleadores2.users.dto;

import java.time.LocalDateTime;

public record UserResponseDTO (
        Long id,
        String username,
        LocalDateTime createdAt
){
}
