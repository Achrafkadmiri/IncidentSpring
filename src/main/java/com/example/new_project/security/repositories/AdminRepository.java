package com.example.new_project.security.repositories;

import com.example.new_project.security.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);


}
