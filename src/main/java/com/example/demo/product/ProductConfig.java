package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

  @Bean
  CommandLineRunner product( ProductRepository repository){
    return args -> {
      Product teste = new Product("teste1","Sale");
      repository.save(teste);
    };
  }

}
