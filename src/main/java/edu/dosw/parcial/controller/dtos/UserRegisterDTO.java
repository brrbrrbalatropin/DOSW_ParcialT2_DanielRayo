package edu.dosw.parcial.controller.dtos;

import edu.dosw.parcial.persistence.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class UserRegisterDTO {
    //@NotBlank(message = "Nombre Obligatorio ");
    private String name ;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
