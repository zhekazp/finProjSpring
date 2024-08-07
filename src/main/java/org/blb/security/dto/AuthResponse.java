package org.blb.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    @Schema(description = "User role", example = "ROLE_ADMIN")
    private String role;
}
