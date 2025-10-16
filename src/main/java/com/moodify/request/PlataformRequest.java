package com.moodify.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record PlataformRequest(@NotEmpty(message = "Nome da Plataforma Obrigatoria!")
                               @Schema(type = "string", description = "Nome da Plataforma")
                               String name) {
}
