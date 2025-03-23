package com.prashantMaurya.PSO.Services;

import com.prashantMaurya.PSO.Entities.UserEntity;
import com.prashantMaurya.PSO.Repo.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoaderService implements UserDetailsService {
  private final Users ur;

  public UserLoaderService(Users u) {
    this.ur = u;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity u = this.ur.findByUsername(username);
    if (u == null) throw new UsernameNotFoundException("User  " + username + " not found!!!");

    return User.builder()
        .username(u.getUsername())
        .password(u.getPassword())
        .roles(u.getRoles().toArray(new String[0]))
        .build();
  }
}
