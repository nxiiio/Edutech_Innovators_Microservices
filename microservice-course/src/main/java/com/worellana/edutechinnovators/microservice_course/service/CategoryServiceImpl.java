package com.worellana.edutechinnovators.microservice_course.service;

import com.worellana.edutechinnovators.microservice_course.dto.CategoryDTO;
import com.worellana.edutechinnovators.microservice_course.exception.CategoryNotFoundException;
import com.worellana.edutechinnovators.microservice_course.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll().stream().map(category -> CategoryDTO.builder()
                .id(category.getId())
                .name(category.getNameCategory()).build())
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategory(int id) {
        return categoryRepository.findById(id).map(category -> CategoryDTO.builder()
                .id(category.getId()).name(category.getNameCategory()).build())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }
}
