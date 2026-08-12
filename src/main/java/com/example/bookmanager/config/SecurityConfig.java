package com.example.bookmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        //ADMIN
                        .requestMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/categories").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/authors").hasRole("ADMIN")
                        //LOGEADO
                        .requestMatchers(HttpMethod.GET, "/users/{userId}/library/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/users/{userId}/library").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/users/{userId}/library/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/users/{userId}/library/**").authenticated()
                        //SIN LOGEAR
                        .requestMatchers(HttpMethod.GET, "/books", "/books/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/authors", "/authors/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/categories", "/categories/**").permitAll()
                        //RESTO DE REGLAS
                        .anyRequest().authenticated()

                )
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}