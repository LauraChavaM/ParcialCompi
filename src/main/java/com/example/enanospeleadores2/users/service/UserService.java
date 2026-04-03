package com.example.enanospeleadores2.users.service;

import com.example.enanospeleadores2.users.dto.UserResponseDTO;
import com.example.enanospeleadores2.users.dto.UserUpdateDTO;
import com.example.enanospeleadores2.users.mapper.UserMapper;
import com.example.enanospeleadores2.users.model.User;
import com.example.enanospeleadores2.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return UserMapper.toDto(user);
    }

    public UserResponseDTO update(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserMapper.updateEntity(user, dto);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }
}