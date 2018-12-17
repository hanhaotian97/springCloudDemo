package com.hht.ribbondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonDemoApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonDemoApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@RequestMapping("/getClientPort")
	public String test(){
		// 直接使用ip访问无法接通
		// return restTemplate.getForEntity("http://localhost:8080/port", String.class).getBody();
		System.out.println("---------调用http://eureka-client-one/port!-----------------");
		return restTemplate.getForEntity("http://eureka-client-one/port", String.class).getBody();
	}
}

