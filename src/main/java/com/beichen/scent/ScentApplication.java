package com.beichen.scent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beichen.scent.*.mapper")
public class ScentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScentApplication.class, args);
    }

}
