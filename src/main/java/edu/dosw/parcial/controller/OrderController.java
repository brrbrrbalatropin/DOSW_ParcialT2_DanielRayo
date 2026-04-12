package edu.dosw.parcial.controller;

import edu.dosw.parcial.core.services.OrderService;
import edu.dosw.parcial.persistence.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam UUID userId, @RequestParam UUID cartId) {
        Order order = orderService.createOrderFromCart(userId , cartId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/payment")
    public ResponseEntity<Void> processPayment(@RequestParam UUID orderId , @RequestParam boolean success){
        orderService.processOrderPayment(orderId , success);
        return ResponseEntity.ok().build();
    }
}
