package com.worellana.edutechinnovators.microservice_course.service;

import com.worellana.edutechinnovators.microservice_course.client.InstructorFeign;
import com.worellana.edutechinnovators.microservice_course.dto.CategoryDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseRequestDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseResponseDTO;
import com.worellana.edutechinnovators.microservice_course.dto.InstructorDTO;
import com.worellana.edutechinnovators.microservice_course.entity.Category;
import com.worellana.edutechinnovators.microservice_course.entity.Course;
import com.worellana.edutechinnovators.microservice_course.exception.CategoryNotFoundException;
import com.worellana.edutechinnovators.microservice_course.exception.CourseNotFoundException;
import com.worellana.edutechinnovators.microservice_course.exception.InstructorNotFoundException;
import com.worellana.edutechinnovators.microservice_course.repository.CategoryRepository;
import com.worellana.edutechinnovators.microservice_course.repository.CourseRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // hace falta mejorar metodos
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository CourseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InstructorFeign instructorFeign;


    @Override // Si hay un curso que no tiene un instructor (o que se haya eliminado) el objeto InstructorDTO tendra valores null
    public List<CourseResponseDTO> getCourses() {
        List<InstructorDTO> instructors = instructorFeign.getAllInstructors();
        return CourseRepository.findAllWithCategory().stream()
                .map(course -> {
                    InstructorDTO instructor = instructors.stream()
                            .filter(i -> course.getIdInstructor().equals(i.getId()))
                            .findFirst()
                            .orElse(new InstructorDTO());
                    return CourseResponseDTO.builder()
                            .id(course.getId())
                            .name(course.getNameCourse())
                            .description(course.getDescriptionCourse())
                            .category(CategoryDTO.builder()
                                    .id(course.getCategory().getId())
                                    .name(course.getCategory().getNameCategory())
                                    .build())
                            .instructor(instructor)
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponseDTO> getCoursesByInstructor(Integer instructorId) {
        return CourseRepository.findCoursesByIdInstructor(instructorId)
                .stream()
                .map(course -> CourseResponseDTO.builder()
                        .id(course.getId())
                        .name(course.getNameCourse())
                        .description(course.getDescriptionCourse())
                        .category(CategoryDTO.builder()
                                .id(course.getCategory().getId())
                                .name(course.getCategory().getNameCategory())
                                .build())
                        .instructor(instructorFeign.getInstructorById(course.getIdInstructor()))
                        .build())
                .toList();
    }

    @Override
    // Si hay un curso que no tiene un instructor (o que se haya eliminado) el objeto InstructorDTO tendra valores null
    public CourseResponseDTO getCourse(Integer id) {
        Course course = CourseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));
        Category category = categoryRepository.findById(course.getCategory().getId()).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        InstructorDTO instructor;
        try {
            instructor = instructorFeign.getInstructorById(course.getIdInstructor());
        } catch (FeignException e) {
            instructor = new InstructorDTO();
        }
        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getNameCourse())
                .description(course.getDescriptionCourse())
                .category(CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getNameCategory()).build())
                .instructor(instructor).build();
    }

    @Override // No puede crear un course nuevo sin el id del instructor y de la categoria
    public CourseResponseDTO saveCourse(CourseRequestDTO course) {
        InstructorDTO instructor;
        Category category = categoryRepository.findById(course.getIdCategory()).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        try {
            instructor = instructorFeign.getInstructorById(course.getIdInstructor());
        } catch (FeignException e) {
            throw new InstructorNotFoundException("Instructor not found");
        }
        Course save = CourseRepository.save(Course.builder()
                .nameCourse(course.getName())
                .descriptionCourse(course.getDescription())
                .category(category)
                .idInstructor(course.getIdInstructor()).build());
        return CourseResponseDTO.builder()
                .id(save.getId())
                .name(save.getNameCourse())
                .description(save.getDescriptionCourse())
                .category(CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getNameCategory()).build())
                .instructor(instructor).build();
    }

    @Override
    public CourseResponseDTO updateCourse(Integer id, CourseRequestDTO client) {
        return CourseRepository.findById(id).map(course -> {
                    InstructorDTO instructor;
                    Category category = categoryRepository.findById(course.getCategory().getId()).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
                    try {
                        instructor = instructorFeign.getInstructorById(client.getIdInstructor());
                    } catch (FeignException e) {
                        throw new InstructorNotFoundException("Instructor not found");
                    }
                    course.setNameCourse(client.getName());
                    course.setDescriptionCourse(client.getDescription());
                    course.setIdInstructor(client.getIdInstructor());
                    course.setCategory(category);
                    CourseRepository.save(course);
                    return CourseResponseDTO.builder()
                            .id(course.getId())
                            .name(course.getNameCourse())
                            .description(course.getDescriptionCourse())
                            .category(CategoryDTO.builder()
                                    .id(category.getId())
                                    .name(category.getNameCategory()).build())
                            .instructor(instructor).build();
                })
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));
    }

    @Override
    public void deleteCourse(Integer id) {
        CourseRepository.delete(CourseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found")));
    }
}


