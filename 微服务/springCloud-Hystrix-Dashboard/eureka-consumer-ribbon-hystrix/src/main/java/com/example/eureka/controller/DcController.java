package com.example.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eureka.service.ConsumerService;

@RestController
public class DcController {
	@Autowired
	ConsumerService consumerService;
	
	//该注解将HTTP Get 映射到 特定的处理方法上,@GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
	@GetMapping("/consumer")
	public String dc() {
		return consumerService.consumer();
	}
}
