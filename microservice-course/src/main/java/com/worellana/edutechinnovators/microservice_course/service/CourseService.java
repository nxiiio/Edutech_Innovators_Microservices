package com.worellana.edutechinnovators.microservice_course.service;


import com.worellana.edutechinnovators.microservice_course.dto.CourseRequestDTO;
import com.worellana.edutechinnovators.microservice_course.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getCourses();
    List<CourseResponseDTO> getCoursesByInstructor(Integer instructorId);
    CourseResponseDTO getCourse(Integer id);
    CourseResponseDTO saveCourse(CourseRequestDTO course);
    CourseResponseDTO updateCourse(Integer id, CourseRequestDTO client);
    void deleteCourse(Integer id);

}
