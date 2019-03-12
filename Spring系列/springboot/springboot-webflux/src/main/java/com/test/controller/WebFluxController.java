package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 传统webmvc方式实现
 * @author 
 *
 */
@RestController
public class WebFluxController {
	
	@GetMapping("/test")
	public String test() {
		return "hello SpringWebFlux!";
	}
	
	//引用对象不会创建内存。
	//int[] price; 数组变量
	//int[] price = new int{1,2,3}; 数组对象
	public static void main(String[] args) {
		String [] a = {"1","2"};
		String [] b = a;
		String [] c = a;
		System.out.println(b[0]+","+b[1]);
		System.out.println(c[0]+","+c[1]);
		System.out.println("-------------");
		b[0] = "8";
		System.out.println(b[0]+","+b[1]);
		System.out.println(c[0]+","+c[1]);
		System.out.println(a[0]+","+a[1]);
	}
}
