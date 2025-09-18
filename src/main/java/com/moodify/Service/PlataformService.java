package com.moodify.Service;

import com.moodify.Mapper.PlataformMapper;
import com.moodify.Model.Plataform;
import com.moodify.Repository.PlataformRepository;
import com.moodify.response.PlataformResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlataformService {
    private final PlataformRepository repository;

    public List<Plataform> listAll() {
        return repository.findAll();
    }

    public PlataformResponse getPlataformId(Long id) {
        Optional<Plataform> plataform = repository.findById(id);
        if(plataform.isPresent()){
            return PlataformMapper.toPlataformResponse(plataform.get());
        }
        return null;
    }

    public Plataform savePlataform(Plataform plataform) {
        return repository.save(plataform);
    }

    public void deletePlataform(Long id) {
        repository.deleteById(id);
    }

    public Plataform getPlataformEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
