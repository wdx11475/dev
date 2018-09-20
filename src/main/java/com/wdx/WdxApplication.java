package com.wdx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wdx.mapper")
public class WdxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdxApplication.class, args);
	}
}
