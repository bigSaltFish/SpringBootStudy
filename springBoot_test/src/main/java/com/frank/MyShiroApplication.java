package com.frank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class MyShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyShiroApplication.class, args);
    }

}

