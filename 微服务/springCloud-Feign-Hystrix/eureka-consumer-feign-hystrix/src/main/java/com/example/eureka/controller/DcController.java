package com.example.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eureka.feign.DcClient;

@RestController
public class DcController {

	@Autowired
	private DcClient dcClient;
	
	//该注解将HTTP Get 映射到 特定的处理方法上,@GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
	@GetMapping("/consumer")
	public String dc() {
		//Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能，也可以通过Ribbon的IRule进行策略扩展
		return this.dcClient.consumer();
	}
}
