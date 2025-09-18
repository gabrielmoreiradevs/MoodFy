package com.moodify.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ContentsResponse(Long id,
                               String title,
                               String description,

                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDate releaseDate,

                               double rating,
                               List<MoodsResponse> moods,
                               List<PlataformResponse> plataforms) {
}
