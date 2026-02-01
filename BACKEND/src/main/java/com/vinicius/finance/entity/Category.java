package com.vinicius.finance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 🔐 categoria pertence a um usuário
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
