package edu.dosw.parcial.persistence.repositories;

import edu.dosw.parcial.persistence.entities.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLogRepository extends MongoRepository<OrderLog, String> {
}
