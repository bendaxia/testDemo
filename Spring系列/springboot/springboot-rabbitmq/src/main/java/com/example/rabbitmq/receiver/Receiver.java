package com.example.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * 
 * @author ben
 *
 */
@Component
@RabbitListener(queues = "hello") //对hello队列进行监听
public class Receiver {
	
	@RabbitHandler //该注解可以指定对消息处理的方法,实现消费
	public void process(String str) {
        System.out.println("Receiver : " + str);
    }
}
