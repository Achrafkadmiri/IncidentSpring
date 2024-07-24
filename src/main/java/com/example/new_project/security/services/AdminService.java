package com.example.new_project.security.services;

import com.example.new_project.security.entities.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin saveAdmin(Admin admin);
    Admin UpdateAdmin(Admin admin);
    Admin getAdmin(Long id);
    Admin findByUsername(String username);

    void deleteAdminById(Long id);


}
