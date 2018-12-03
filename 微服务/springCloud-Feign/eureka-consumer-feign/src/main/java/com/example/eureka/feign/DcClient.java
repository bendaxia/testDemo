package com.example.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//指定这个接口所要调用的服务名称，接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
@FeignClient("eureka-client")
public interface DcClient {
	
	@GetMapping("/dc")
	String consumer();
}
