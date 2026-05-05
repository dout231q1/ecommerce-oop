package com.example.shop.payment.impl;

import com.example.shop.payment.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod {
    @Override
    public Double pay(double amount){
        double taxRate = 0.05;
        double taxAmount = amount * taxRate;
        double amountAfterTax = amount + taxAmount;
        return amountAfterTax;
    }
}
