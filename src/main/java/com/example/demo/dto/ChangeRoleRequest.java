package com.example.demo.dto;

import com.example.demo.enums.Role;
import lombok.Getter;

@Getter
public class ChangeRoleRequest {
    private String email;
    private Role role;
}
