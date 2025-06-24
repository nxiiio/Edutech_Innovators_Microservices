package com.worellana.edutechinnovators.microservice_client.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Nombre requerido")
    String name;

    @NotBlank(message = "Email requerido")
    @Email(message = "El email debe ser valido")
    String email;

    @NotNull(message = "Edad requerida")
    Integer age;
}
