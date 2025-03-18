package com.prashantMaurya.PSO.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewRoute {
  @GetMapping
  public String getHome() {
    return "index";
  }

  @GetMapping("signup")
  public String getSignUpPage() {
    return "register";
  }
}
