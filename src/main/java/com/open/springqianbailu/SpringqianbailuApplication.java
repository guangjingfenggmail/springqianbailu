package com.open.springqianbailu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.open.springqianbailu.dao")
public class SpringqianbailuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringqianbailuApplication.class, args);
    }
}
