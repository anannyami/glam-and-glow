package com.anannya.glamandglow.service;

import com.anannya.glamandglow.dto.LoginRequestDTO;
import com.anannya.glamandglow.dto.LoginResponseDTO;
import com.anannya.glamandglow.dto.RegisterRequestDTO;
import com.anannya.glamandglow.dto.UserResponseDTO;
import com.anannya.glamandglow.entity.Role;
import com.anannya.glamandglow.entity.User;
import com.anannya.glamandglow.exception.ResourceAlreadyExistsException;
import com.anannya.glamandglow.exception.ResourceNotFoundException;
import com.anannya.glamandglow.mapper.UserMapper;
import com.anannya.glamandglow.repository.UserRepository;
import com.anannya.glamandglow.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public UserResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return LoginResponseDTO.builder()
                .message("Login successful")
                .token(token)
                .email(user.getEmail())
                .build();
    }

}