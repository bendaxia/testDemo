package com.example.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Autowired
    RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		//Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，
		//自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}

	@Override
	public String fallback() {
		// TODO Auto-generated method stub
		return "fallback";
	}
}
