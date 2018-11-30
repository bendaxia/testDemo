package com.example.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient//让注册中心能够发现当前服务
@SpringBootApplication
public class ConsulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulServerApplication.class, args);
	}
	/**
	 * https://springcloud.cc/spring-cloud-consul.html
	 */
}
