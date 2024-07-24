package com.example.new_project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SecurityConfig {
//    @Autowired
//    PasswordEncoder passwordEncoder;
 /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().loginPage("/login").successForwardUrl("/accueil").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjar/**","/resources/**", "/css/**").permitAll();
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return  httpSecurity.build();
    }
 @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/
}
