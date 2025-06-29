package com.worellana.edutechinnovators.microservice_course.service;

import com.worellana.edutechinnovators.microservice_course.client.InstructorFeign;
import com.worellana.edutechinnovators.microservice_course.dto.CourseDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseResponseDTO;
import com.worellana.edutechinnovators.microservice_course.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_course.entity.Course;
import com.worellana.edutechinnovators.microservice_course.exception.CourseNotFoundException;
import com.worellana.edutechinnovators.microservice_course.exception.InstructorNotFoundException;
import com.worellana.edutechinnovators.microservice_course.repository.CourseRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private InstructorFeign instructorFeign;


    @Override // Si hay un curso que no tiene un instructor (o que se haya eliminado) el objeto InstructorDTO tendra valores null
    public List<CourseResponseDTO> getCourses() {
        return repository.findAll().stream().map(course -> {
            InstructorDTO instructor;
            try {
                instructor = instructorFeign.getInstructorById(course.getIdInstructor());
            } catch (FeignException e) {
                instructor = new InstructorDTO();
            }
           return CourseResponseDTO.builder()
                   .id(course.getId())
                   .nameCourse(course.getNameCourse())
                   .descriptionCourse(course.getDescriptionCourse())
                   .instructor(instructor).build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<CourseResponseDTO> getCoursesByInstructor(Integer instructorId) {
        return repository.findCoursesByIdInstructor(instructorId).stream().map(course ->
                CourseResponseDTO.builder()
                        .id(course.getId())
                        .nameCourse(course.getNameCourse())
                        .descriptionCourse(course.getDescriptionCourse())
                        .instructor(instructorFeign.getInstructorById(course.getIdInstructor())).build()).collect(Collectors.toList());
    }

    @Override // Si hay un curso que no tiene un instructor (o que se haya eliminado) el objeto InstructorDTO tendra valores null
    public CourseResponseDTO getCourse(Integer id) {
        Course course = repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));
        InstructorDTO instructor;
        try {
            instructor = instructorFeign.getInstructorById(course.getIdInstructor());
        } catch (FeignException e) {
            instructor = new InstructorDTO();
        }
        return CourseResponseDTO.builder()
                .id(course.getId())
                .nameCourse(course.getNameCourse())
                .descriptionCourse(course.getDescriptionCourse())
                .instructor(instructor).build();
    }

    @Override // No puede crear un course nuevo sin el id del instructor
    public CourseResponseDTO saveCourse(CourseDTO course) {
        InstructorDTO instructor;
        try {
            instructor = instructorFeign.getInstructorById(course.getIdInstructor());
        } catch (FeignException e) {
            throw new InstructorNotFoundException("Instructor not found");
        }
       Course save = repository.save(Course.builder()
                .nameCourse(course.getNameCourse())
                .descriptionCourse(course.getDescriptionCourse())
                .idInstructor(course.getIdInstructor()).build());
        return CourseResponseDTO.builder()
                .id(save.getId())
                .nameCourse(save.getDescriptionCourse())
                .descriptionCourse(save.getNameCourse())
                .instructor(instructor).build();
    }

    @Override
    public CourseResponseDTO updateCourse(Integer id, CourseDTO client) {
        return repository.findById(id).map(course -> {
            InstructorDTO instructor;
            try {
                instructor = instructorFeign.getInstructorById(client.getIdInstructor());
            } catch (FeignException e) {
                throw new InstructorNotFoundException("Instructor not found");
            }
            course.setNameCourse(client.getNameCourse());
            course.setDescriptionCourse(client.getDescriptionCourse());
            course.setIdInstructor(client.getIdInstructor());
            repository.save(course);
            return CourseResponseDTO.builder()
                    .id(course.getId())
                    .nameCourse(course.getNameCourse())
                    .descriptionCourse(course.getDescriptionCourse())
                    .instructor(instructor).build();
        })
        .orElseThrow(() -> new CourseNotFoundException("Course not found"));
    }

    @Override
    public void deleteCourse(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found")));
    }
}


