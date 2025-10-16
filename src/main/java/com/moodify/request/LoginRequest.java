package com.moodify.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "string", description = "Email")
                            String email,
                           @Schema(type = "string", description = "Senha")
                           String password) {
}
