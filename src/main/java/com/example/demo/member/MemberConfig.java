package com.example.demo.member;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository repository){
      return args -> {
        Member gabriell = new Member("Gabriell");
        Member alex = new Member("Alex");
        repository.saveAll(List.of(gabriell,alex));
      };
    }
}
