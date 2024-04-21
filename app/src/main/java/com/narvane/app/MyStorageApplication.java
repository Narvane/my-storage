package com.narvane.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.narvane.app", "com.narvane.infra"})
public class MyStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStorageApplication.class, args);
    }

}
