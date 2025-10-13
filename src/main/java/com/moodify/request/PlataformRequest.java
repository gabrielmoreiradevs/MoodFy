package com.moodify.request;

import jakarta.validation.constraints.NotEmpty;

public record PlataformRequest(@NotEmpty(message = "Nome da Plataforma Obrigatoria!") String name) {
}
