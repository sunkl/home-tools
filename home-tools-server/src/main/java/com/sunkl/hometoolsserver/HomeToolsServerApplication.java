package com.sunkl.hometoolsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HomeToolsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeToolsServerApplication.class, args);
    }

}
