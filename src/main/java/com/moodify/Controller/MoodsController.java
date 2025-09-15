package com.moodify.Controller;

import com.moodify.Controller.Mapper.MoodsMapper;
import com.moodify.Controller.request.MoodsRequest;
import com.moodify.Controller.response.MoodsResponse;
import com.moodify.Model.Moods;
import com.moodify.Service.MoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moodify/moods")
@RequiredArgsConstructor

public class MoodsController {

    private final MoodsService moodsService;

    @GetMapping()
    public ResponseEntity<List<MoodsResponse>> listarTodosOsMoods(){
        List<Moods> list = moodsService.listarTodosOsMoods();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list.stream()
                .map(MoodsMapper::toMoodsResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<MoodsResponse> adicionarUmNovoMood(@RequestBody MoodsRequest moods){
        Moods mood =  MoodsMapper.toMoods(moods);
        Moods save = moodsService.addMood(mood);
        return ResponseEntity.status(HttpStatus.CREATED).body(MoodsMapper.toMoodsResponse(save));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoodsResponse> buscarMoodPorId(@PathVariable Long id){
        MoodsResponse moodsResponse = moodsService.buscarMoodPorId(id);

        if(moodsResponse != null){
            return ResponseEntity.status(HttpStatus.OK).body(moodsResponse);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMoodPorId(@PathVariable Long id){
        moodsService.deletarMood(id);
        return ResponseEntity.noContent().build();
    }

}
