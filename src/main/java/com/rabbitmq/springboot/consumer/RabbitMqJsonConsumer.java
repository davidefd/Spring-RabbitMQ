package com.rabbitmq.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbitmq.springboot.dto.User;

@Service
public class RabbitMqJsonConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);
	
	@RabbitListener(queues = {"javaguides_json"})
	public void consumeJson(User user) {
		LOGGER.info(String.format("Mensaje JSON recivido -> %s", user.toString()));
	}

}
