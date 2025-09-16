package com.moodify.Mapper;

import com.moodify.Model.Plataform;
import com.moodify.request.PlataformRequest;
import com.moodify.response.PlataformResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlataformMapper {

    // Request -> Entity
    public static Plataform toPlataform(PlataformRequest plataformRequest) {
        return Plataform.builder()
                .name(plataformRequest.name())
                .build();
    }

    // Entity -> Response
    public static PlataformResponse toPlataformResponse(Plataform plataform) {
        return PlataformResponse.builder()
                .id(plataform.getId())
                .name(plataform.getName())
                .build();
    }
}
