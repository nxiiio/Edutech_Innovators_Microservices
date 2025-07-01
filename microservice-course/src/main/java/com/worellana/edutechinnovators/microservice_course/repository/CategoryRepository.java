package com.worellana.edutechinnovators.microservice_course.repository;

import com.worellana.edutechinnovators.microservice_course.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
