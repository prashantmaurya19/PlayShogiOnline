package com.prashantMaurya.PSO.Configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        request ->
            request
                .requestMatchers("/game-ws/**", "/public/**", "/", "/signup/**", "/register/**")
                .permitAll()
                .requestMatchers(
                    PathRequest.toH2Console(), PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .requestMatchers("/user/**", "/auth/**")
                .authenticated()
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated());
    http.httpBasic(Customizer.withDefaults())
        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
        .formLogin(
            (form) ->
                form.loginPage("/login")
                    .defaultSuccessUrl("/auth/dashboard", true) // Redirect to /welcome after login
                    .permitAll())
        .logout()
        .permitAll();
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
