package com.worellana.edutechinnovators.microservice_instructor.service;

import com.worellana.edutechinnovators.microservice_instructor.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_instructor.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getInstructors();
    Instructor getInstructor(Integer id);
    Instructor addInstructor(InstructorDTO instructor);
    Instructor updateInstructor(Integer id, InstructorDTO instructor);
    void deleteInstructor(Integer id);
}
