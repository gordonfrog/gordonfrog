package com.gordonfrog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.gordonfrog.model.User;
import com.gordonfrog.service.UserService;

@Component
@Profile("k8s")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MongoDB_DataLoader implements CommandLineRunner {
 
    private final Logger logger = LoggerFactory.getLogger(MongoDB_DataLoader.class);
 
    private UserService service;
 
    public MongoDB_DataLoader(UserService service) {
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

