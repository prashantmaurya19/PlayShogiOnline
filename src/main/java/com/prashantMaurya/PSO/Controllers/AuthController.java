package com.prashantMaurya.PSO.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
  @GetMapping("/dashboard")
  public String getLoginPage() {
    return "dashboard";
  }
}
