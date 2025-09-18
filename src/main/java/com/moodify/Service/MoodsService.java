package com.moodify.Service;

import com.moodify.Mapper.MoodsMapper;
import com.moodify.response.MoodsResponse;
import com.moodify.Model.Moods;
import com.moodify.Repository.MoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoodsService {
    private final MoodsRepository moodsRepository;

    public List<Moods> listarTodosOsMoods(){
        return moodsRepository.findAll();
    }

    public Moods addMood(Moods moods){
        return moodsRepository.save(moods);
    }

    public MoodsResponse buscarMoodPorId(Long id){
        Optional<Moods> moods = moodsRepository.findById(id);
        if(moods.isPresent()){
            return MoodsMapper.toMoodsResponse(moods.get());
        }
        return null;
    }

    public void deletarMood(Long id){
        moodsRepository.deleteById(id);
    }

    public Moods buscarMoodEntityPorId(Long id) {
        return moodsRepository.findById(id).orElse(null);
    }


}
