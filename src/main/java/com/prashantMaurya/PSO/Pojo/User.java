package com.prashantMaurya.PSO.Pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  private String username;
  private String password;
  private List<String> roles;

  @Override
  public String toString() {
    // Your custom implementation here
    return "User(" + this.username + ", " + this.password + ")";
  }
}
