package com.worellana.edutechinnovators.microservice_instructor.service;

import com.worellana.edutechinnovators.microservice_instructor.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_instructor.entity.Instructor;
import com.worellana.edutechinnovators.microservice_instructor.exception.EmailAlreadyExitsException;
import com.worellana.edutechinnovators.microservice_instructor.exception.InstructorNotFoundException;
import com.worellana.edutechinnovators.microservice_instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository repository;

    @Override
    public List<Instructor> getInstructors() {
        return repository.findAll();
    }

    @Override
    public Instructor getInstructor(Integer id) {
        return repository.findById(id).orElseThrow(()-> new InstructorNotFoundException("Instructor not found"));
    }

    @Override
    public Instructor addInstructor(InstructorDTO instructor) {
        if (repository.existsByEmail(instructor.getEmail())) {
            throw new EmailAlreadyExitsException("The email already exits");
        }
        return repository.save(Instructor.builder()
                .name(instructor.getName())
                .email(instructor.getEmail())
                .specialization(instructor.getSpecialization()).build());
    }

    @Override
    public Instructor updateInstructor(Integer id, InstructorDTO instructor) {
        return repository.findById(id)
                .map(user -> {
                    if (repository.existsByEmail(instructor.getEmail()) &&
                        !user.getEmail().equals(instructor.getEmail())) {
                        throw new EmailAlreadyExitsException("The email already exits");
                    }
                    user.setName(instructor.getName());
                    user.setEmail(instructor.getEmail());
                    user.setSpecialization(instructor.getSpecialization());
                    return repository.save(user);
                })
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found"));
    }

    @Override
    public void deleteInstructor(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new InstructorNotFoundException("Instructor not found")));
    }
}
