package com.thulani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Textbook_SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Textbook_SystemApplication.class, args);
    }
}