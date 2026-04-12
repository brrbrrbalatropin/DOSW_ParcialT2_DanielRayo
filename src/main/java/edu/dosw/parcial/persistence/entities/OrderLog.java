package edu.dosw.parcial.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "order_logs")
@Builder
@Getter
@Setter
public class OrderLog {
    @Id
    private String id;

    @Field("order_id")
    private UUID orderId;

    @Field("user_id")
    private UUID userId;

    private List<LogItem> items;
    private String status;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @Builder
    public static class LogItem {
        private UUID productId;
        private String productName;
        private Integer quantity;
        private Double unitPrice;
    }
}
