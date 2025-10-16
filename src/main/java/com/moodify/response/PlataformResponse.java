package com.moodify.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PlataformResponse(@Schema(type = "string", description = "Id da Plataforma") Long id,
                                @Schema(type = "string", description = "Id da Plataforma") String name) {
}
