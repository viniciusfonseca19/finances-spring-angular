package com.vinicius.finance.repository;

import com.vinicius.finance.entity.Transaction;
import com.vinicius.finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserAndDateBetween(
            User user,
            LocalDate start,
            LocalDate end
    );
}
