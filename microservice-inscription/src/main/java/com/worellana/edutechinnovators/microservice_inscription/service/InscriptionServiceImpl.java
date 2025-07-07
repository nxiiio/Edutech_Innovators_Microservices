package com.worellana.edutechinnovators.microservice_inscription.service;

import com.worellana.edutechinnovators.microservice_inscription.client.ClientFeign;
import com.worellana.edutechinnovators.microservice_inscription.client.CourseFeign;
import com.worellana.edutechinnovators.microservice_inscription.dto.*;
import com.worellana.edutechinnovators.microservice_inscription.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionRepository repository;

    @Autowired
    private ClientFeign clientFeign;

    @Autowired
    private CourseFeign courseFeign;

    @Override
    public List<InscriptionResponseDTO> getInscriptions() {
        List<ClientDTO> clients = clientFeign.getClients();
        List<CourseDTO> courses = courseFeign.getCourses();
        return repository.findAll().stream()
                .map(inscription -> {

            ClientDTO client = clients.stream()
                    .filter(i -> inscription.getIdClient().equals(i.getId()))
                    .findFirst()
                    .orElse(new ClientDTO());

            CourseDTO course = courses.stream()
                    .filter(i -> inscription.getIdCourse().equals(i.getId()))
                    .findFirst()
                    .orElse(new CourseDTO());

            return InscriptionResponseDTO.builder()
                    .id(inscription.getId())
                    .dateInscription(inscription.getDateInscription())
                    .additionalInformation(inscription.getAdditionalInformation())
                    .client(ClientDTO.builder()
                            .id(client.getId())
                            .name(client.getName())
                            .age(client.getAge())
                            .email(client.getEmail())
                            .build())
                    .course(CourseDTO.builder()
                            .id(course.getId())
                            .name(course.getName())
                            .description(course.getDescription()).build())
                    .build();
                    })
                .toList();
    }

    @Override
public InscriptionResponseDTO getInscription(Integer id) {
    return repository.findById(id).map(inscription -> {
        ClientDTO client;
        CourseDTO course;
        try {
            client = clientFeign.getClientById(inscription.getIdClient());
            course = courseFeign.getCourse(inscription.getIdCourse());
        } catch (Exception e) {
            client = new ClientDTO();
            course = new CourseDTO();
        }
        return InscriptionResponseDTO.builder()
                .id(inscription.getId())
                .dateInscription(inscription.getDateInscription())
                .additionalInformation(inscription.getAdditionalInformation())
                .client(ClientDTO.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .age(client.getAge())
                        .email(client.getEmail())
                        .build())
                .course(CourseDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .description(course.getDescription()).build())
                .build();
    }).orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ID: " + id));
}

    @Override
    public List<InscriptionResponseDTO> getInscriptionsByClientID(Integer idClient) {
        List<ClientDTO> clients = clientFeign.getClients();
        List<CourseDTO> courses = courseFeign.getCourses();

        return repository.findAllByIdClient(idClient).stream().map(inscription -> {
            ClientDTO client = clients.stream().filter(
                    clientDTO -> inscription.getIdClient().equals(clientDTO.getId()))
                    .findFirst().orElse(new ClientDTO());

            CourseDTO course = courses.stream().filter(
                     courseDTO -> inscription.getIdCourse().equals(courseDTO.getId()))
                    .findFirst().orElse(new CourseDTO());

            return InscriptionResponseDTO.builder()
                    .id(inscription.getId())
                    .dateInscription(inscription.getDateInscription())
                    .additionalInformation(inscription.getAdditionalInformation())
                    .client(ClientDTO.builder()
                            .id(client.getId())
                            .name(client.getName())
                            .age(client.getAge())
                            .email(client.getEmail()).build())
                    .course(CourseDTO.builder()
                            .id(course.getId())
                            .name(course.getName())
                            .description(course.getDescription()).build())
                    .build();
        }).toList();
    }


}
