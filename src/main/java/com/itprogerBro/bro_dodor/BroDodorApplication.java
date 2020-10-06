package com.itprogerBro.bro_dodor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Slf4j
@SpringBootApplication
//@ComponentScan(basePackages = "com.itprogerBro.bro_dodor")
@EnableJpaRepositories(basePackages = {"com.itprogerBro.bro_dodor.repo"})
public class BroDodorApplication {

    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("contex.xml");
        SpringApplication.run(BroDodorApplication.class, args);

        log.info("OK");
         
    }

}
