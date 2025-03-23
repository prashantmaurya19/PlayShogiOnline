package com.prashantMaurya.PSO.Pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;

  @Size(min = 4, max = 10, message = "First name must be between 4 and 10 characters")
  private String firstName;

  @Size(min = 4, max = 10, message = "Last name must be between 4 and 10 characters")
  private String lastName;

  @Email(message = "Invalid email format")
  private String email;

  @Size(min = 4, max = 10, message = "Username must be between 4 and 10 characters")
  private String username;

  @Size(min = 4, max = 10, message = "Password must be between 4 and 10 characters")
  private String password;

  private List<String> roles;

  @Override
  public String toString() {
    // Your custom implementation here
    return "User("
        + this.firstName
        + ", "
        + this.lastName
        + ", "
        + this.username
        + ", "
        + this.password
        + ", "
        + this.email
        + ")";
  }
}
