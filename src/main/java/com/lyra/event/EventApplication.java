package com.lyra.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
