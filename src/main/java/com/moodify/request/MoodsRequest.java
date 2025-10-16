package com.moodify.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record MoodsRequest(@NotEmpty(message = "Nome do Humor Obrigatorio")
                           @Schema(type = "string", description = "Nome do Humor")
                           String name) {
}
