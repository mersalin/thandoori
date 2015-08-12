package com.tastydine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Mersalin on 5/13/2015.
 * Added changes to read context files - 21/06/2015
 */
@SpringBootApplication
@Configuration
@ImportResource({"classpath*:*-context.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
