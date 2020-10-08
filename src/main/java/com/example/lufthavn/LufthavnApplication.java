package com.example.lufthavn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class LufthavnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LufthavnApplication.class, args);
    }

}
