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
}
