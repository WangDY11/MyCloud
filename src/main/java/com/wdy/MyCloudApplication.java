package com.wdy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients(basePackages = "com.wdy.login.feign")
@EnableScheduling
@EnableAsync
@MapperScan({"com.wdy.login.mapper"})
@SpringBootApplication
public class MyCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyCloudApplication.class, args);
    }
}
