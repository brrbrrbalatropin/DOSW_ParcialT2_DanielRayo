package edu.dosw.parcial.core.services;

import edu.dosw.parcial.persistence.entities.Cart;
import edu.dosw.parcial.persistence.entities.Order;
import edu.dosw.parcial.persistence.entities.OrderLog;
import edu.dosw.parcial.persistence.entities.OrderStatus;
import edu.dosw.parcial.persistence.entities.User;
import edu.dosw.parcial.core.services.PaymentStrategy;
import edu.dosw.parcial.persistence.repositories.CartRepository;
import edu.dosw.parcial.persistence.repositories.OrderLogRepository;
import edu.dosw.parcial.persistence.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderLogRepository orderLogRepository;
    private final Map<String , PaymentStrategy> paymentStrategies;

    @Transactional
    public Order createOrderFromCart(UUID userId , UUID cartId) {
        User userReference = User.builder().id(userId).build();
        boolean hasActivateOrder = orderRepository.existsByUserAndStatusIn(
                userReference,
                List.of(OrderStatus.CREADO, OrderStatus.EN_PREPARACION)
        );

        if (hasActivateOrder) {
            throw new IllegalStateException("El usuario ya tiene un pedido activo");
        }

        Cart cart = cartRepository.findById(cartId).orElseThrow();

        Order newOrder = Order.builder()
                .id(UUID.randomUUID())
                .user(userReference)
                .status(OrderStatus.CREADO)
                .price(cart.getTotal())
                .createdAt(LocalDateTime.now())
                .build();

        orderRepository.save(newOrder);

        List<OrderLog.LogItem> logItems = cart.getItems().stream()
                .map(item -> OrderLog.LogItem.builder()
                        .productId(item.getProduct().getId())
                        .productName(item.getProduct().getName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getProduct().getPrice())
                        .build())
                .collect(Collectors.toList());

        OrderLog log = OrderLog.builder()
                .orderId(newOrder.getId())
                .userId(userId)
                .status(newOrder.getStatus().name())
                .createdAt(LocalDateTime.now())
                .items(logItems)
                .build();

        orderLogRepository.save(log);

        return  newOrder;
    }

    @Transactional
    public void processOrderPayment(UUID orderId, boolean paymentSuccess) {
        Order order = orderRepository.findById(orderId).orElseThrow();

        PaymentStrategy strategy = paymentSuccess ?
                paymentStrategies.get("approvedPayment") :
                paymentStrategies.get("rejectedPayment");

        strategy.processPayment(order);
        orderRepository.save(order);
    }

}
