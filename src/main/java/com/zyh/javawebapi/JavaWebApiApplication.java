package com.zyh.javawebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JavaWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebApiApplication.class, args);
    }

}
