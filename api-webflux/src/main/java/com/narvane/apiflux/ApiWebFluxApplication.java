package com.narvane.apiflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.narvane.apiflux", "com.narvane.infra"})
public class ApiWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiWebFluxApplication.class, args);
    }

}
