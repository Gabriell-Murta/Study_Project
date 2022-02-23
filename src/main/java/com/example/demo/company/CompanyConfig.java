package com.example.demo.company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {

  @Bean
  CommandLineRunner teste(CompanyRepository repository){
    return args -> {
      Company test = new Company("QuintoAndar");
      repository.save(test);
    };
  }
}
