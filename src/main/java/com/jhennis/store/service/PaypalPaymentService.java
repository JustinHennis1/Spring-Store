package com.jhennis.store.service;

import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("PaypalPaymentService");
        System.out.println("Processing payment of " + amount);
    }
}
