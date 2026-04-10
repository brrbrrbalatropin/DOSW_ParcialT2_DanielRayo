package edu.dosw.parcial.persistence.repositories;

import java.util.Optional;
import java.util.UUID;
import edu.dosw.parcial.persistence.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , UUID> {

    boolean existsByUserAndStatusIn(User user , java.util.List<OrderStatus> statuses);
}
