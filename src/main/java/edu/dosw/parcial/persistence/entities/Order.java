package edu.dosw.parcial.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

