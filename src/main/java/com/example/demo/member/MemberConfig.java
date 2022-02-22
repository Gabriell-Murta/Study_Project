package com.example.demo.member;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner members(MemberRepository repository){
      return args -> {
        Member gabriell = new Member("John");
        Member alex = new Member("Alex");
        repository.saveAll(List.of(gabriell,alex));
      };
    }
}
