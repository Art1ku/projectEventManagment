package com.example.demo.service;

import com.example.demo.dto.ChangeRoleRequest;
import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/role")
    public ResponseEntity<Role> changeRole(@RequestBody ChangeRoleRequest changeRoleRequest) {
        return ResponseEntity.ok(userService.executeChange(changeRoleRequest));
    }
}
