package com.prashantMaurya.PSO.Controllers;

import com.prashantMaurya.PSO.Pojo.User;
import com.prashantMaurya.PSO.Services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewRoute {
  private final UserService us;
  private static final Logger logger = LoggerFactory.getLogger(ViewRoute.class);

  public ViewRoute(UserService us) {
    this.us = us;
  }

  @GetMapping
  public String getHome() {
    return "index";
  }

  @GetMapping("/signup")
  public String getSignUpPage(Model model) {
    model.addAttribute("csslink", "/css/register.css");
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/signup")
  public String processSingUpForm(
      @Valid @ModelAttribute("userobj") User user, BindingResult result, Model model) {
    logger.info(user.toString());
    if (result.hasErrors()) {
      model.addAttribute("user", user);
      model.addAttribute("csslink", "/css/register.css");
      return "register";
    }

    this.us.create(user);

    return "redirect:/login";
  }
}
