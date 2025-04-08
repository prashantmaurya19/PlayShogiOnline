package com.prashantMaurya.PSO.Services;

import com.prashantMaurya.PSO.Entities.UserEntity;
import com.prashantMaurya.PSO.Pojo.User;
import com.prashantMaurya.PSO.Repo.Users;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  final Users ur;
  final ModelMapper mm;
  final PasswordEncoder pe;

  public UserService(Users a, ModelMapper mm, PasswordEncoder pe) {
    this.ur = a;
    this.mm = mm;
    // this.js = js;
    this.pe = pe;
  }

  public boolean isValidRole(User u) {
    if (u.getRoles() == null) return false;
    u.getRoles().removeIf(e -> (!e.equals("USER") && !e.equals("ADMIN")));
    return u.getRoles().size() > 0;
  }

  public boolean isValidUser(User u) {
    return !(u.getUsername() == null
        || u.getPassword() == null
        || u.getPassword().equals("")
        || u.getUsername().equals(""));
  }

  public boolean isValidUser(UserEntity u) {
    return !(u.getUsername() == null
        || u.getPassword() == null
        || u.getPassword().equals("")
        || u.getUsername().equals(""));
  }

  public UserEntity saveNewUser(UserEntity u) {
    u.setPassword(this.pe.encode(u.getPassword()));
    this.ur.save(u);
    return u;
  }

  public User getUserByUsername(String username) {
    UserEntity d = this.ur.findByUsername(username);
    if (d == null) return null;
    return this.mm.map(d, User.class);
  }

  public List<User> getAll() {
    return this.ur.findAll().stream().map(entity -> this.mm.map(entity, User.class)).toList();
  }

  @Transactional
  public User create(User u) {
    if (!this.isValidUser(u)) return null;
    if (!this.isValidRole(u)) {
      u.setRoles(new ArrayList<>());
      u.getRoles().add("USER");
    }
    this.saveNewUser(this.mm.map(u, UserEntity.class));
    return u;
  }

  @Transactional
  public User updateUserCredentials(User newu, String username) {
    UserEntity u = this.ur.findByUsername(username);
    if (u == null) return null;
    if (!this.isValidUser(newu)) return null;
    u.setUsername(newu.getUsername());
    u.setPassword(this.pe.encode(newu.getPassword()));
    u.setRoles(this.isValidRole(newu) ? newu.getRoles() : u.getRoles());
    this.ur.save(u);
    return this.mm.map(u, User.class);
  }

  @Transactional
  public User deleteById(String username) {
    UserEntity u = this.ur.findByUsername(username);
    if (u == null) return null;
    User d = this.mm.map(u, User.class);
    this.ur.deleteById(u.getId());
    return d;
  }
}
