package com.xxland.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.xxland.myspringboot.common.LogUtils;

@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}

    @Bean
    @Scope("singleton")
    LogUtils apiLogger(){
    	return LogUtils.getInstance(MyspringbootApplication.class);
    }
}
