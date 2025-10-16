package com.moodify.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record ContentsRequest(  @Schema(type = "string", description = "Nome do Conteudo")
                                @NotEmpty(message = "Nome do conteudo obrigatorio!")
                                String title,

                                @Schema(type = "string", description = "Descrição do Conteudo")
                                String description,

                                @Schema(type = "localDate", description = "Data de Criação")
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                              LocalDate releaseDate,

                                @Schema(type = "double", description = "Pontuação do Conteudo")
                                double rating,
                              List<Long> moods,
                              List<Long> plataforms){
}
