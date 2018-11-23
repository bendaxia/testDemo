package com.spring;

import com.spring.core.ioc.ClassPathXmlApplicationContext;
import com.spring.test.service.BService;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext();
		BService aService = (BService) cpxa.getBean("BService");
		aService.init();
	}
}
