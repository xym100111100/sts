package com.wboly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.wboly.mapper")
public class StsApplication {
    public static void main(final String[] args) {
        SpringApplication.run(StsApplication.class, args);
    }
}
