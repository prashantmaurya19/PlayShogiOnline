package com.prashantMaurya.PSO.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
  @GetMapping("/game")
  public String getGamePage() {
    return "game";
  }

  @GetMapping("/setting")
  public String getSettingPage() {
    return "setting";
  }

  @GetMapping("/dashboard")
  public String getDashboard() {
    return "dashboard";
  }
}
