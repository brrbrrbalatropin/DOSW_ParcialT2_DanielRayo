package edu.dosw.parcial.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.nio.file.FileStore;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public void SetName(String name) {
    }

    public void SetEmail(String email) {
    }

    public void SetPassword(String password) {
    }

    public void SetRole(Role role) {
    }
}
