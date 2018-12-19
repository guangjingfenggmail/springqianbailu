package com.open.springqianbailu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:dubbo-consumer.xml"})
public class SpringqianbailuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringqianbailuApplication.class, args);
    }


}
