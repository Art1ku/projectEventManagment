package com.example.demo.service;

import com.example.demo.dto.ChangeRoleRequest;
import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.exception.ServiceException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Role executeChange(ChangeRoleRequest changeRoleRequest) {
        User user = userRepository.findByEmail(changeRoleRequest.getEmail()).orElseThrow(
                () -> new ServiceException("User not found")
        );

        user.setRole(changeRoleRequest.getRole());
        userRepository.save(user);
        return user.getRole();
    }
}
