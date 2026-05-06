package com.example.shop.service;

import com.example.shop.database.entity.Cart;
import com.example.shop.database.entity.Order;
import com.example.shop.database.entity.Product;
import com.example.shop.database.entity.User;
import com.example.shop.database.repository.CartRepository;
import com.example.shop.database.repository.OrderRepository;
import com.example.shop.database.repository.UserRepository;
import com.example.shop.exception.ResourceNotFoundException;
import com.example.shop.payment.PaymentMethod;
import com.example.shop.payment.impl.BoletoPayment;
import com.example.shop.payment.impl.CreditCardPayment;
import com.example.shop.payment.impl.PixPayment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private CartService cartService;
    private CreditCardPayment creditCardPayment;
    private PixPayment pixPayment;
    private BoletoPayment boletoPayment;
    private CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, CartService cartService, CreditCardPayment creditCardPayment, PixPayment pixPayment, BoletoPayment boletoPayment) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartService = cartService;
        this.creditCardPayment = creditCardPayment;
        this.pixPayment = pixPayment;
        this.boletoPayment = boletoPayment;
    }

    public List<Order> getOrderHistoryById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return orderRepository.findByUser(user);
    }

    @Transactional
    public Order checkout(Long userId, String payment){
        Cart cart = cartService.getCartByUser(userId);
        User user = cart.getUser();
        Double total = cartService.getTotalPrice(userId);
        if(user.getBalance() < total){
            throw new RuntimeException("Insufficient funds.");
        }

        PaymentMethod paymentMethod = getPaymentMethod(payment);
        Double valueCharged = paymentMethod.pay(total);

        user.setBalance(user.getBalance() - valueCharged);
        userRepository.save(user);

        List<Product> orderProducts = new ArrayList<>(cart.getProducts());
        Order order = new Order(user, orderProducts, valueCharged, payment);
        orderRepository.save(order);

        cart.getProducts().clear();
        cartService.save(cart);
        return order;
    }

    private PaymentMethod getPaymentMethod(String payment){
        if(payment.equalsIgnoreCase("Credit Card")) return creditCardPayment;
        if(payment.equalsIgnoreCase("Pix")) return pixPayment;
        if(payment.equalsIgnoreCase("Boleto")) return boletoPayment;

        throw new ResourceNotFoundException("Payment Method not found:" + payment);
    }
}