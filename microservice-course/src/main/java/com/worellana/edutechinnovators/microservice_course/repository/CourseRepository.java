package com.worellana.edutechinnovators.microservice_course.repository;

import com.worellana.edutechinnovators.microservice_course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCoursesByIdInstructor(Integer idInstructor);

    @Query("SELECT c FROM Course c JOIN FETCH c.category") // Para solucionar el problema N+1 (con findAll se hacian demasiadas consultas hacia la bdd)
    List<Course> findAllWithCategory();
}
