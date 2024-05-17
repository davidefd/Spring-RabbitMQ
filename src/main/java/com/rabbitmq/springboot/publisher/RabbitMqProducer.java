package com.rabbitmq.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

	private String exchange = "javaguides_exchange";

	private String routingKey = "javaguides_routing_key";

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(String message) {
		LOGGER.info(String.format("Mensaje enviado -> %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}

}
