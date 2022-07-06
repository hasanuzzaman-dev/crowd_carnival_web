package com.hasan.crowdcarnival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class CrowdCarnivalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CrowdCarnivalApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CrowdCarnivalApplication.class);
    }

}
