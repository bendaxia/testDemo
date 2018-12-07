package com.example.rabbitmq.send;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 * 
 * @author ben
 *
 */
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;// AmqpTemplate接口定义了一套针对AMQP协议的基础操作

	public void send() {
		String context = "hello rabbitmq" + new Date();
		System.out.println("Sender: " + context);
		this.rabbitTemplate.convertAndSend("hello",context);//将消息发送到队列名为hello的队列中
	}

}
