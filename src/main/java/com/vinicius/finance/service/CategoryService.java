package com.vinicius.finance.service;

import com.vinicius.finance.dto.category.CategoryRequestDTO;
import com.vinicius.finance.dto.category.CategoryResponseDTO;
import com.vinicius.finance.entity.Category;
import com.vinicius.finance.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(c -> new CategoryResponseDTO(c.getId(), c.getName()))
                .toList();
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        repository.save(category);

        return new CategoryResponseDTO(category.getId(), category.getName());
    }
}
