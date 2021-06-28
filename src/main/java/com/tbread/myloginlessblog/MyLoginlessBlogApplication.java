package com.tbread.myloginlessblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyLoginlessBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLoginlessBlogApplication.class, args);
    }

}
