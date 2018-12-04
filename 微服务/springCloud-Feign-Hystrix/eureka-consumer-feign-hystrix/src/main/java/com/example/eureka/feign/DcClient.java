package com.example.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

//指定这个接口所要调用的服务名称，接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
//Feign已经集成了hystrix 只需把配置开启(配置文件中feign.hystrix.enabled=true )
@FeignClient( name = "eureka-client" , fallback = DcClient.DcClientFallBack.class)
public interface DcClient {
	
	@GetMapping("/dc")
	String consumer();
	
	
	@Service
	class DcClientFallBack implements DcClient{

		@Override
		public String consumer() {
			return "fallback";
		}
		
	}
}
