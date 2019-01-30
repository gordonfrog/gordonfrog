package com.gordonfrog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.gordonfrog.model.User;
import com.gordonfrog.service.UserService;

@Component
@Profile("docker")
@EnableAutoConfiguration
public class MySQL_DataLoader implements CommandLineRunner {
 
    private final Logger logger = LoggerFactory.getLogger(MySQL_DataLoader.class);
 
    private UserService service;
 
    public MySQL_DataLoader(UserService service) {
        this.service = service;
    }
 
    @Override
    public void run(String... strings) throws Exception {
        logger.info("Loading data...");
 
        service.save(new User(1, "Phil Herold", "Manager", "R&D"));
        service.save(new User(2, "Chris Olinger", "CTO", "Executive"));
        service.save(new User(3, "John Leveille", "CEO", "Executive"));
 
        logger.info("Data has been loaded.");
    }
}

