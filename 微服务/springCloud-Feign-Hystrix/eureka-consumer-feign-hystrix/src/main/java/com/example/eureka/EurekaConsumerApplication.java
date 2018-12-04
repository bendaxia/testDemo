package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients //开启扫描Spring Cloud Feign客户端的功能
@EnableDiscoveryClient //注解用来将当前应用加入到服务治理体系中。
@SpringBootApplication
public class EurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
