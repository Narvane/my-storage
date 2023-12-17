package com.narvane.apimvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.narvane.apimvc", "com.narvane.inframvc"})
public class ApiWebMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiWebMvcApplication.class, args);
    }

}
