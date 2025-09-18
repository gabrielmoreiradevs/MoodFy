package com.moodify.Mapper;

import com.moodify.Model.Contents;
import com.moodify.Model.Moods;
import com.moodify.Model.Plataform;
import com.moodify.request.ContentsRequest;
import com.moodify.response.ContentsResponse;
import com.moodify.response.MoodsResponse;
import com.moodify.response.PlataformResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ContentsMapper {

    public static Contents toContents(ContentsRequest request) {
        List<Moods> moodListId = request.moods().stream()
                .map(id -> Moods.builder().Id(id).build())
                .toList();

        List<Plataform> plataformList = request.plataforms().stream()
                .map(id -> Plataform.builder().id(id).build())
                .toList();

        return Contents.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .moods(moodListId)
                .plataforms(plataformList)
                .build();
    }

    public static ContentsResponse toContentsResponse(Contents contents) {

        List<MoodsResponse> moodsResponseList = contents.getMoods().stream()
                .map(id -> MoodsMapper.toMoodsResponse(id))
                .toList();

        List<PlataformResponse> listPlataform = contents.getPlataforms().stream()
                .map(plataform -> PlataformMapper.toPlataformResponse(plataform))
                .toList();

        return ContentsResponse.builder()
                .id(contents.getId())
                .title(contents.getTitle())
                .description(contents.getDescription())
                .releaseDate(contents.getReleaseDate())
                .rating(contents.getRating())
                .moods(moodsResponseList)
                .plataforms(listPlataform)
                .build();
    }
}
