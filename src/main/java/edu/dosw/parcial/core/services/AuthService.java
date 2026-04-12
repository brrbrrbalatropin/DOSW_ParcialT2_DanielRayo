package edu.dosw.parcial.core.services;

import edu.dosw.parcial.controller.dtos.request.UserRegisterDTO;
import edu.dosw.parcial.persistence.entities.Role;
import edu.dosw.parcial.persistence.entities.User;
import edu.dosw.parcial.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Transactional
    public User registerUser(UserRegisterDTO request) {
        if (!request.getEmail().endsWith("@escuelaing.edu.co")) {
            throw new IllegalArgumentException("Solo se permiten correos institucionales de la ECI");
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalStateException("El correo ya se encuentra registrado en ECIXPRESS");
        }

        User newUser = userFactory.createUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                Role.CLIENTE
        );

        return userRepository.save(newUser);
    }
}