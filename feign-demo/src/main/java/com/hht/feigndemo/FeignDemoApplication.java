package com.hht.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.hht.feigndemo.test"})
//@EnableEurekaClient
@EnableFeignClients
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}

}

