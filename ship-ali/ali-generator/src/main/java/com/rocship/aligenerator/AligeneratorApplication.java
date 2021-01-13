package com.rocship.aligenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class AligeneratorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AligeneratorApplication.class, args);
    }

}
