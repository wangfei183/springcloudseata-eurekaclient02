package com.example.springcloudseataeurekaclient03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
public class SpringcloudseataEurekaclient03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudseataEurekaclient03Application.class, args);
    }

}
