package com.example.api;

import com.example.data.config.BasePropertySource;
import com.example.data.config.ConfigJpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.example"})
@Import(ConfigJpaRepository.class)
@BasePropertySource
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}
