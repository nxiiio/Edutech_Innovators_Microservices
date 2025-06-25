package com.worellana.edutechinnovators.microservice_instructor.repository;

import com.worellana.edutechinnovators.microservice_instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    boolean existsByEmail(String email);
}
