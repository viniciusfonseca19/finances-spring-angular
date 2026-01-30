package com.vinicius.finance.service;

import com.vinicius.finance.dto.transaction.*;
import com.vinicius.finance.entity.Category;
import com.vinicius.finance.entity.Transaction;
import com.vinicius.finance.entity.User;
import com.vinicius.finance.exception.ResourceNotFoundException;
import com.vinicius.finance.repository.CategoryRepository;
import com.vinicius.finance.repository.TransactionRepository;
import com.vinicius.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    // 🔐 pega o usuário logado via JWT
    private User getAuthenticatedUser() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    // ➕ criar transação
    public TransactionResponseDTO create(TransactionRequestDTO dto) {

        User user = getAuthenticatedUser();

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        Transaction transaction = Transaction.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .type(dto.getType())
                .category(category)
                .user(user)
                .build();

        Transaction saved = transactionRepository.save(transaction);

        return TransactionResponseDTO.fromEntity(saved);
    }

    // 📄 listar transações do usuário
    public List<TransactionResponseDTO> findAll() {

        User user = getAuthenticatedUser();

        return transactionRepository
                .findByUser(user)
                .stream()
                .map(TransactionResponseDTO::fromEntity)
                .toList();
    }

    // 🔍 buscar por ID
    public TransactionResponseDTO findById(Long id) {

        User user = getAuthenticatedUser();

        Transaction transaction = transactionRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Transação não encontrada"));

        return TransactionResponseDTO.fromEntity(transaction);
    }

    // ❌ deletar
    public void delete(Long id) {

        User user = getAuthenticatedUser();

        Transaction transaction = transactionRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Transação não encontrada"));

        transactionRepository.delete(transaction);
    }
}
