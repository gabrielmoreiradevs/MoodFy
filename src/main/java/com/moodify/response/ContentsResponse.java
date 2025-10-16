package com.moodify.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ContentsResponse(@Schema(type = "Long", description = "Id do Conteudo")
                                Long id,
                               @Schema(type = "string", description = "Nome do Conteudo")
                               String title,
                               @Schema(type = "string", description = "Descrição do Conteudo")
                               String description,

                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDate releaseDate,

                               @Schema(type = "double", description = "Score do Conteudo")
                               double rating,
                               List<MoodsResponse> moods,
                               List<PlataformResponse> plataforms) {
}
