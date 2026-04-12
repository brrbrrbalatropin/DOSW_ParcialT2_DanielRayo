package edu.dosw.parcial.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductDetail {

    @Id
    private String id;

    @Field("Product_id")
    private UUID productID;

    private List<String> images;
    private Map<String, Object> specs;
    private String weight;
    private String material;
    private List<String> sizes;
    private List<String> tags;

    @Field("updated_at")
    private LocalDateTime updatedAt;

}
