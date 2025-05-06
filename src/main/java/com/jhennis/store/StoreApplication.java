package com.jhennis.store;

import com.jhennis.store.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
//		var orderservice = context.getBean(OrderService.class);
//		orderservice.placeOrder();
//		new OrderService(new StripePaymentService()).placeOrder();
//
//		new OrderService(new PaypalPaymentService()).placeOrder();
	}

}
