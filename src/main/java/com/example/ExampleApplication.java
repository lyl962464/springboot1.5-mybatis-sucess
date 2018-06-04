package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ExampleApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
