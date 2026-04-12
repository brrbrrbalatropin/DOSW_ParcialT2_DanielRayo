package edu.dosw.parcial.core.services;
import edu.dosw.parcial.persistence.entities.Role;
import org.springframework.stereotype.Component;
import edu.dosw.parcial.persistence.entities.User;

import java.time.LocalDateTime;

import static edu.dosw.parcial.persistence.entities.User.*;

@Component

public class UserFactory {
        public User createUser (String name, String email , String password , Role role )
    {
                    User user = new User();
                    user.SetName(name);
                    user.SetEmail(email);
                    user.SetPassword(password);
                    user.SetRole(role);
                    user.setCreatedAt(LocalDateTime.now());

                    return user;
    }
}
