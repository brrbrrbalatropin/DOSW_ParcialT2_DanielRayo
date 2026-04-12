package edu.dosw.parcial.persistence.repositories;

import edu.dosw.parcial.persistence.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart , UUID> {
}
