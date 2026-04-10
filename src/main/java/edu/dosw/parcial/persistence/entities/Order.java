package edu.dosw.parcial.persistence.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double price;
    @ElementCollection
    private List<UUID> productIds;
}

