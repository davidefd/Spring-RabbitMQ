package com.rabbitmq.springboot.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	
	private String queue = "javaguides";
	
	private String jsonQueue = "javaguides_json";
	
	private String exchange = "javaguides_exchange";
	
	private String routingKey = "javaguides_routing_key";
	
	private String routingJsonKey = "javaguides_routing_json_key";
	
	@Bean
	public Queue queue() {
		return new Queue(queue); 
	}
	
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue); 
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange); 
	}
	
	@Bean
	public Binding bindig() {
		return BindingBuilder.bind(queue())
							 .to(exchange())
							 .with(routingKey);
	}
	
	@Bean
	public Binding jsonBindig() {
		return BindingBuilder.bind(jsonQueue())
							 .to(exchange())
							 .with(routingJsonKey);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}

}
