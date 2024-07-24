package com.example.new_project;

import com.example.new_project.security.entities.Admin;
import com.example.new_project.security.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableAsync
public class NewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewProjectApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//@Bean
	CommandLineRunner commandLineRunner(AdminService adminService) {
		return args -> {
			adminService.saveAdmin(new Admin(1L,"admin1","p@sswrd"));
			adminService.saveAdmin(new Admin(2L,"admin2","admin"));

		};
	}

	}

