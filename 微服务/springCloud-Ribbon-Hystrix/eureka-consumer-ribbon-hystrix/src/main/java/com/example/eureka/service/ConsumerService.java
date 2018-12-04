package com.example.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface ConsumerService {
	public String consumer();
	public String fallback();
}
