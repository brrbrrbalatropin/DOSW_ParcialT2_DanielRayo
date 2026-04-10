package edu.dosw.parcial.persistence.repositories;

import edu.dosw.parcial.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductReposity extends JpaRepository<Product, UUID> {
}
