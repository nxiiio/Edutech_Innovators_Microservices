package com.worellana.edutechinnovators.microservice_inscription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    Integer id;
    String name;
    String email;
    Integer age;
}
