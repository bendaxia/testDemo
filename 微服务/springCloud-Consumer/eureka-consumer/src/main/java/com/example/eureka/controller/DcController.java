package com.example.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {
	@Autowired
    LoadBalancerClient loadBalancerClient;
	@Autowired
    RestTemplate restTemplate;
	
	//该注解将HTTP Get 映射到 特定的处理方法上,@GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
	@GetMapping("/consumer")
	public String dc() {
		ServiceInstance instance  = loadBalancerClient.choose("eureka-client");//负载均衡选出一个client实例
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/dc";
        System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}
