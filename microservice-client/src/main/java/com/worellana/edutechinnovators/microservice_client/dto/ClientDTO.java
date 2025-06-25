package com.worellana.edutechinnovators.microservice_client.dto;


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

    @NotBlank
    String name;

    @NotBlank
    @Email
    String email;

    @NotNull
    Integer age;
}
