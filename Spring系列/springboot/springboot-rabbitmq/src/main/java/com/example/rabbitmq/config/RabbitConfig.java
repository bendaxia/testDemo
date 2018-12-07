package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该配置类用来配置队列,交换器,路由等信息
 * 
 * @author ben
 *
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Queue hellwQueue() {
		return new Queue("hello");
	}
}
