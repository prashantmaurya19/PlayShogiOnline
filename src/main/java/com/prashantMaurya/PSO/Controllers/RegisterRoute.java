package com.prashantMaurya.PSO.Controllers;

import com.prashantMaurya.PSO.Pojo.RegisterResponse;
import com.prashantMaurya.PSO.Pojo.User;
import com.prashantMaurya.PSO.Services.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterRoute {

  @Autowired private UserService us;

  @PostMapping(
      path = "/cu",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<RegisterResponse> createUser(
      @RequestBody MultiValueMap<String, String> msg) {
    ArrayList<String> r = new ArrayList<String>();
    r.add("User");
    User u = new User(null, msg.get("username").getFirst(), msg.get("password").getFirst(), r);
    RegisterResponse d = this.us.create(u);
    return new ResponseEntity<RegisterResponse>(d, HttpStatus.OK);
  }

  @GetMapping("check-health")
  public String checkHealth() {
    return "OK";
  }
}
