package edu.dosw.parcial.controller.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe tener un formato de correo válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}

