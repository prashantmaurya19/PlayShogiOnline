package com.prashantMaurya.PSO.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig {
  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
