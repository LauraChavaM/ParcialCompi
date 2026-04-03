package com.example.enanospeleadores2.users.mapper;

import com.example.enanospeleadores2.users.dto.UserResponseDTO;
import com.example.enanospeleadores2.users.dto.UserUpdateDTO;
import com.example.enanospeleadores2.users.model.User;

public class UserMapper {

    private UserMapper() {}

    public static void updateEntity(User user, UserUpdateDTO dto) {
        user.setUsername(dto.username());
    }

    public static UserResponseDTO toDto(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getCreatedAt()
        );
    }
}
