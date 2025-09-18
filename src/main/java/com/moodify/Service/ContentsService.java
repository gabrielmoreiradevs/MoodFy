package com.moodify.Service;

import com.moodify.Model.Contents;
import com.moodify.Model.Moods;
import com.moodify.Model.Plataform;
import com.moodify.Repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;
    private final MoodsService moodsService;
    private final PlataformService plataformService;

    public Contents save(Contents  contents) {
        contents.setMoods(this.findMoods(contents.getMoods()));
        contents.setPlataforms(this.findPlataform(contents.getPlataforms()));
        return contentsRepository.save(contents);
    }

    public List<Contents> findAll(){
        return contentsRepository.findAll();
    }

    public Optional<Contents> findById(Long id){
        Optional<Contents> contents = contentsRepository.findById(id);
        return contents;
    }

    public List<Contents> findByContentsInContents(Long moodId){
        return contentsRepository.findContentsByMoods_Id(moodId);
    }

    public Optional<Contents> update(Contents  updateConstents, Long id) {
        Optional<Contents> optContents = contentsRepository.findById(id);
        if(optContents.isPresent()) {
            List<Moods> moodsList = this.findMoods(updateConstents.getMoods());
            List<Plataform> plataformList = this.findPlataform(updateConstents.getPlataforms());

            Contents contents = optContents.get();
            contents.setTitle(updateConstents.getTitle());
            contents.setDescription(updateConstents.getDescription());
            contents.setReleaseDate(updateConstents.getReleaseDate());
            contents.setRating(updateConstents.getRating());

            contents.getMoods().clear();
            contents.getMoods().addAll(moodsList);

            contents.getPlataforms().clear();
            contents.getPlataforms().addAll(plataformList);

            contentsRepository.save(contents);

            return Optional.of(contents);
        }
        return Optional.empty();
    }

    public void delete(Long id){
        contentsRepository.deleteById(id);
    }

    private List<Moods> findMoods(List<Moods> moodsList){
        List<Moods> list = new ArrayList<>();
        for (Moods mood : moodsList) {
            Moods moodEntity = moodsService.buscarMoodEntityPorId(mood.getId());
            if (moodEntity != null) {
                list.add(moodEntity);
            }
        }
        return list;
    }

    private List<Plataform> findPlataform(List<Plataform> plataformList){
        List<Plataform> result = new ArrayList<>();
        for (Plataform plataform1 : plataformList) {
            Plataform plataform2 = plataformService.getPlataformEntityById(plataform1.getId());
            if (plataform2 != null) {
                result.add(plataform2);
            }
        }
        return result;
    }
}
