package com.example.new_project.security.services;
import com.example.new_project.security.entities.Role;
import com.example.new_project.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(String role) {
        Role r=Role.builder()
                .role(role)
                .build();
        return roleRepository.save(r);
    }


}
