package com.itprogerBro.bro_dodor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.itprogerBro.bro_dodor")
@EnableJpaRepositories(basePackages = {"com.itprogerBro.bro_dodor.repo"})
public class BroDodorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BroDodorApplication.class, args);
    }

}
