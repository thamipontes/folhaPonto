package com.example.folha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FolhaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FolhaApplication.class, args);
    }
}
