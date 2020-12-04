package com.bjpowernode;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(basePackages = "com.bjpowernode.mapper")
public class DataService {

	public static void main(String[] args) {
		SpringApplication.run(DataService.class, args);
	}

}
