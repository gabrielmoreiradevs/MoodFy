package com.moodify.request;

import jakarta.validation.constraints.NotEmpty;

public record MoodsRequest(@NotEmpty(message = "Nome do Humor Obrigatorio") String name) {
}
