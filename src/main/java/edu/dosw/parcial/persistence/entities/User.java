package edu.dosw.parcial.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.nio.file.FileStore;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public void SetName(String name) {
    }

    public void SetEmail(String email) {
    }

    public void SetPassword(String password) {
    }

    public void SetRole(Role role) {
    }
}
