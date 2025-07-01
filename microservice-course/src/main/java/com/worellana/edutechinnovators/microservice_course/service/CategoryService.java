package com.worellana.edutechinnovators.microservice_course.service;

import com.worellana.edutechinnovators.microservice_course.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategories();
    CategoryDTO getCategory(int id);
}
