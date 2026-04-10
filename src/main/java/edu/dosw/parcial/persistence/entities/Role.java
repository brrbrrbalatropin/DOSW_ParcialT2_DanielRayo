package edu.dosw.parcial.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter

public enum Role {
    CLIENTE , ADMIN
}
