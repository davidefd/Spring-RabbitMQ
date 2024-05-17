package com.rabbitmq.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.springboot.dto.User;

@Service
public class RabbitMqJsonProducer {

	private String exchange = "javaguides_exchange";

	private String routingJsonKey = "javaguides_routing_json_key";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("Mensaje JSON enviado -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
	}
}
