package com.moodify.Mapper;

import com.moodify.request.MoodsRequest;
import com.moodify.response.MoodsResponse;
import com.moodify.Model.Moods;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MoodsMapper {

    public static Moods toMoods(MoodsRequest moodsRequest){
        return Moods
                .builder()
                .Name(moodsRequest.name())
                .build();
    }

    public static MoodsResponse toMoodsResponse(Moods moods){
        return MoodsResponse
                .builder()
                .id(moods.getId())
                .name(moods.getName())
                .build();
    }
}
