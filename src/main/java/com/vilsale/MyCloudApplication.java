package com.vilsale;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients(basePackages = "com.vilsale.login.feign")
@EnableScheduling
@EnableAsync
@MapperScan({"com.vilsale.login.mapper"})
@SpringBootApplication
public class MyCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyCloudApplication.class, args);
    }
}
