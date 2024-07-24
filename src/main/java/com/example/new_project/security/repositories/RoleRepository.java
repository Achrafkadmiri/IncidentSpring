package com.example.new_project.security.repositories;

import com.example.new_project.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {

}
