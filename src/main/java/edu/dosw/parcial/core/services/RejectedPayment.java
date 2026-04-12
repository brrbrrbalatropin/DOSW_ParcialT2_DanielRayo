package edu.dosw.parcial.core.services;

import edu.dosw.parcial.persistence.entities.Order;
import edu.dosw.parcial.persistence.entities.OrderStatus;
import org.springframework.stereotype.Component;

@Component("rejectedPayment")
public class RejectedPayment implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        order.setStatus(OrderStatus.CANCELADO);
    }
}
