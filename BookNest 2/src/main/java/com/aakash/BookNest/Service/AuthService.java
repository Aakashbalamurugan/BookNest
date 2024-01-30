package com.aakash.BookNest.Service;

import com.aakash.BookNest.DAO.UserDao;
import com.aakash.BookNest.DTO.SignUpDto;
import com.aakash.BookNest.Exception.InvalidJwtException;
import com.aakash.BookNest.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService implements UserDetailsService {

  @Autowired
  UserDao repository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    var user = repository.findByLogin(username);
    return user;
  }

  public UserDetails signUp(SignUpDto data) throws InvalidJwtException {

    if (repository.findByLogin(data.login()) != null) {
      throw new InvalidJwtException("Username already exists");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

    User newUser = new User(data.login(), encryptedPassword, data.role());

    return repository.save(newUser);

  }
}