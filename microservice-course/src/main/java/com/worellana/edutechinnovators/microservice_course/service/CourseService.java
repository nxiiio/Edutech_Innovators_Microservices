package com.worellana.edutechinnovators.microservice_course.service;


import com.worellana.edutechinnovators.microservice_course.dto.CourseDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseResponseDTO;
import com.worellana.edutechinnovators.microservice_course.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getCourses();
    List<CourseResponseDTO> getCoursesByInstructor(Integer instructorId);
    CourseResponseDTO getCourse(Integer id);
    CourseResponseDTO saveCourse(CourseDTO course);
    CourseResponseDTO updateCourse(Integer id, CourseDTO client);
    void deleteCourse(Integer id);

}
