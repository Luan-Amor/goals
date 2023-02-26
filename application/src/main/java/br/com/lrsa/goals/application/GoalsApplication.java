package br.com.lrsa.goals.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.lrsa.goals")
public class GoalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalsApplication.class, args);
    }
}