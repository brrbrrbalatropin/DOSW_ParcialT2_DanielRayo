package edu.dosw.parcial.core.services;

import edu.dosw.parcial.persistence.entities.Order;

public interface PaymentStrategy {
    void processPayment(Order order);

}
