package com.prashantMaurya.PSO.Configuration;

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
    return http.authorizeHttpRequests(
            request ->
                request
                    .requestMatchers(
                        "/public/**",
                        "/static/**",
                        "/h2/**",
                        "/",
                        "/signup/**",
                        "/register/**",
                        "/login/**")
                    .permitAll()
                    .requestMatchers("/user/**", "/auth")
                    .authenticated()
                    .requestMatchers("/admin/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated())
        .httpBasic(Customizer.withDefaults())
        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
        .formLogin(
            (form) ->
                form.loginPage("/login")
                    .defaultSuccessUrl("/auth/dashboard", true) // Redirect to /welcome after login
                    .permitAll())
        .logout()
        .permitAll()
        // .and()
        // .sessionManagement()
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf(AbstractHttpConfigurer::disable)
        // .authenticationManager(authenticationManager)
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
