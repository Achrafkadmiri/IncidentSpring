package com.example.new_project.security.services;


import com.example.new_project.security.entities.Admin;
import com.example.new_project.security.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Admin saveAdmin(Admin admin) {
        Admin admin1=adminRepository.findByUsername(admin.getUsername());
        if (admin1 != null) throw new RuntimeException("exist");
        Admin c=Admin.builder()
                .username(admin.getUsername())
                .password(passwordEncoder.encode(admin.getPassword()))
                .build();
        return adminRepository.save(c);
    }

    @Override
    public Admin UpdateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdmin(Long id) {
        return null;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }


    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }





}
