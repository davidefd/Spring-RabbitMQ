package com.rabbitmq.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rabbitmq.springboot.dto.User;
import com.rabbitmq.springboot.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
	
	@Autowired
	private RabbitMqJsonProducer jsonProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Mensaje JSON enviado al servidor de RabbitMQ...");
	}

}
