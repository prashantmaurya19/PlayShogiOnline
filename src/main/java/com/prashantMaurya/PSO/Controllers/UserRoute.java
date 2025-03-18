package com.prashantMaurya.PSO.Controllers;

import com.prashantMaurya.PSO.Pojo.User;
import com.prashantMaurya.PSO.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRoute {

  @Autowired private UserService us;

  @GetMapping("/checkhealth")
  public ResponseEntity<String> checkHealth() {
    return new ResponseEntity<String>("Ok", HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<User> getUser() {
    Authentication au = SecurityContextHolder.getContext().getAuthentication();
    User d = this.us.getUserByUsername(au.getName());
    System.out.println("username :" + au.getName() + " d=" + d);
    return new ResponseEntity<User>(d, d == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<User> updateUserCredential(@RequestBody User newu) {
    Authentication au = SecurityContextHolder.getContext().getAuthentication();
    User d = this.us.updateUserCredentials(newu, au.getName());
    return new ResponseEntity<User>(d, d == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity<User> deleteUser() {
    Authentication au = SecurityContextHolder.getContext().getAuthentication();
    User d = this.us.deleteById(au.getName());
    return new ResponseEntity<User>(d, d == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }
}
