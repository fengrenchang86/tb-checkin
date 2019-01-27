package com.turtlebone.checkin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@MapperScan("com.turtlebone.checkin")
@SpringBootApplication
@EnableDubboConfiguration
public class CheckinApp {
	public static void main(String[] args) {
        SpringApplication.run(CheckinApp.class, args);
	}

}
