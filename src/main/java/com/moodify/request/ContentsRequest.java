package com.moodify.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record ContentsRequest(String title,
                              String description,

                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                              LocalDate releaseDate,

                              double rating,
                              List<Long> moods,
                              List<Long> plataforms){
}
