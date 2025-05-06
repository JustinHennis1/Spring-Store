package com.jhennis.store.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("StripePaymentService");
        System.out.println("Processing payment of " + amount);
    }
}
