package com.vinicius.finance.dto.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String message;
}
