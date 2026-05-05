package com.example.shop.payment.impl;

import com.example.shop.payment.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PixPayment implements PaymentMethod {
    @Override
    public Double pay(double amount) {
        return amount;
    }
}
