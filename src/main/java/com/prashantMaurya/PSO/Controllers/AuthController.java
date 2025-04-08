package com.prashantMaurya.PSO.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@Slf4j
public class AuthController {

  private String handleUserDataToModel(String success, String fail, Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    try {
      if (authentication != null && authentication.isAuthenticated()) {
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
          UserDetails userDetails = (UserDetails) principal;
          String username = userDetails.getUsername(); // Get the username
          model.addAttribute("uname", username);
        } else {
          // If the principal is not a UserDetails, it might be a String (username)
          String username = principal.toString();
          model.addAttribute("uname", username);
        }
      } else {
        model.addAttribute("uname", "Guest"); // Or handle as you wish
      }
    } catch (Exception e) {
      log.error("" + e);
      return fail;
    }
    return success;
  }

  @GetMapping("/game")
  public String getGamePage(Model model) {
    return this.handleUserDataToModel("game", "redirect://", model);
  }

  @GetMapping("/setting")
  public String getSettingPage() {
    return "setting";
  }

  @GetMapping("/dashboard")
  public String getDashboard(Model model) {
    return this.handleUserDataToModel("dashboard", "redirect://", model);
  }
}
