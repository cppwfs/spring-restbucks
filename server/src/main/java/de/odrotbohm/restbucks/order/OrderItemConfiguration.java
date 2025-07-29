package de.odrotbohm.restbucks.order;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderItemConfiguration {

	public static final String ORDER_ITEM = "orderitems";

	@Bean
	public Binding orderItemBinding(Queue queue, Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ORDER_ITEM).noargs();
	}

	@Bean
	Exchange exchange() {
		return ExchangeBuilder.directExchange(ORDER_ITEM).build();
	}
	@Bean
	Queue queue(){
		return QueueBuilder.durable(ORDER_ITEM).build();
	}
}
