package com.example.folha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FolhaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FolhaApplication.class, args);
        System.out.print(new BCryptPasswordEncoder().encode("123"));
    }
}
