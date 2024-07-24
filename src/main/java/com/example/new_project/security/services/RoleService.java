package com.example.new_project.security.services;

import com.example.new_project.security.entities.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role saveRole(String role);

}
