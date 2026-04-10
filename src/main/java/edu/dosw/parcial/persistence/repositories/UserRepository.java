package edu.dosw.parcial.persistence.repositories;

import java.util.Optional;
import java.util.UUID;
import edu.dosw.parcial.persistence.entities.User;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , UUID> {
        Optional<User>
    findByEmail(String email);
}
