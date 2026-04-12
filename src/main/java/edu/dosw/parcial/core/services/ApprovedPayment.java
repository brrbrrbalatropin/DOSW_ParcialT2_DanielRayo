package edu.dosw.parcial.core.services;

import edu.dosw.parcial.persistence.entities.Order;
import edu.dosw.parcial.persistence.entities.OrderStatus;
import org.springframework.stereotype.Component;

@Component("approvedPayment")
public class ApprovedPayment implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        order.setStatus(OrderStatus.ENTREGADO);
    }
}
