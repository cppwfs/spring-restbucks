package io.spring.dashboard.statistics;

import java.util.Map;

import javax.money.MonetaryAmount;

import io.spring.dashboard.core.Currencies;
import io.spring.dashboard.order.OrderPaid;
import org.javamoney.moneta.Money;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dashboard {

	private MonetaryAmount revenue = Money.zero(Currencies.EURO);

	@GetMapping("/statistics")
	Map<String, Object> statistics() {
		return Map.of("revenue", revenue);
	}

	@RabbitListener(queues = "orderitems", messageConverter = "jsonMessageConverter")
	public void on(OrderPaid event) {
		this.revenue = revenue.add(convertToRevenue(event));
	}

	private MonetaryAmount convertToRevenue(OrderPaid event) {
		return Money.of(Double.valueOf(event.total().substring(3)), Currencies.EURO);
	}
}
