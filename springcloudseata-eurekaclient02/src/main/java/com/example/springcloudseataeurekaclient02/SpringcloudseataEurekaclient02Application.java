package com.example.springcloudseataeurekaclient02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
public class SpringcloudseataEurekaclient02Application {
    private static Logger logger= LoggerFactory.getLogger(SpringcloudseataEurekaclient02Application.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudseataEurekaclient02Application.class, args);
        logger.info("seata——account启动完毕-----------------------------------------------");
    }


}
