package com.gordonfrog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ "com.gordonfrog" })
@EnableAutoConfiguration (exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
@RestController
@EnableSwagger2
public class Application {

    @RequestMapping("/")
    public String home() {
        return "App is up and running";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
