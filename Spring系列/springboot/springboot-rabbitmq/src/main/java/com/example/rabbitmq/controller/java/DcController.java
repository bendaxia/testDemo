package com.example.rabbitmq.controller.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.send.Sender;

@RestController
public class DcController {
	@Autowired
	Sender sender;

	@GetMapping("/dc")
	public void send() {
		this.sender.send();
	}
}
