package com.app.hostman;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hostname Generator API", version = "2.0", description = "Hostname Information"))
public class HostnameApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostnameApplication.class, args);
    }

}
