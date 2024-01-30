package com.aakash.BookNest.config;

import com.aakash.BookNest.Model.Role;
import com.aakash.BookNest.config.auth.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AuthConfig {
  @Autowired
  SecurityFilter securityFilter;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/api/v1/auth/*").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/api/v1/books/update-Book").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/v1/books/add-book").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/v1/books/deleteBook/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/v1/books/book/").permitAll()
                   .requestMatchers(HttpMethod.GET, "/api/v1/books/all-book").permitAll()
                            .requestMatchers(HttpMethod.POST,"/category/add").hasRole("ADMIN")
                            .requestMatchers("/author/addAuthor").hasRole("ADMIN")
                            .requestMatchers("/author/updateAuthor").hasRole("ADMIN")
                            .requestMatchers("/author/get-all").permitAll()
                    .anyRequest().authenticated()

                    )

            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
  }

  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
          throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}