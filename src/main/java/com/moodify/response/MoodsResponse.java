package com.moodify.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record MoodsResponse(@Schema(type = "Long", description = "Id do Humor") Long id,
                            @Schema(type = "string", description = "Nome do Humor") String name) {
}
