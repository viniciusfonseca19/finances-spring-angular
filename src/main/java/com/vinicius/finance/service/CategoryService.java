package com.vinicius.finance.service;

import com.vinicius.finance.dto.category.*;
import com.vinicius.finance.entity.Category;
import com.vinicius.finance.entity.User;
import com.vinicius.finance.exception.ResourceNotFoundException;
import com.vinicius.finance.repository.CategoryRepository;
import com.vinicius.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    // 🔐 usuário autenticado
    private User getAuthenticatedUser() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    // 📄 listar categorias do usuário
    public List<CategoryResponseDTO> findAll() {

        User user = getAuthenticatedUser();

        return categoryRepository
                .findByUser(user)
                .stream()
                .map(CategoryResponseDTO::fromEntity)
                .toList();
    }

    // ➕ criar categoria
    public CategoryResponseDTO create(CategoryRequestDTO dto) {

        User user = getAuthenticatedUser();

        Category category = Category.builder()
                .name(dto.getName())
                .user(user)
                .build();

        Category saved = categoryRepository.save(category);

        return CategoryResponseDTO.fromEntity(saved);
    }

    // ❌ deletar categoria
    public void delete(Long id) {

        User user = getAuthenticatedUser();

        Category category = categoryRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        categoryRepository.delete(category);
    }
}
