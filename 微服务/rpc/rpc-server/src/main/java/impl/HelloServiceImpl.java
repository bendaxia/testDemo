package impl;

import interfaces.HelloService;

public class HelloServiceImpl implements HelloService{

	public String hello(String helloText) {
		System.out.println("server接收到消息:"+helloText);
		return "hi----"+helloText;
	}

}
