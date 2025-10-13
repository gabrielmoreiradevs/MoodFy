package com.moodify.Controller;

import com.moodify.Mapper.PlataformMapper;
import com.moodify.Model.Plataform;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.moodify.Service.PlataformService;
import com.moodify.request.PlataformRequest;
import com.moodify.response.PlataformResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/moodfy/plataforms")
@RequiredArgsConstructor

public class PlataformController {
    private final PlataformService service;

    @GetMapping
    public ResponseEntity<List<PlataformResponse>> listarTodasPlataformas() {
        List<Plataform> listAll = service.listAll();

        return ResponseEntity.ok(listAll.stream()
                .map(PlataformMapper::toPlataformResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlataformResponse> getPlataformId(@PathVariable Long id) {
        PlataformResponse plataformResponse = service.getPlataformId(id);
        if(plataformResponse != null){
            return ResponseEntity.ok(plataformResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PlataformResponse> savePlataform(@Valid @RequestBody PlataformRequest plataformRequest) {
        Plataform plataformEntity = PlataformMapper.toPlataform(plataformRequest);
        Plataform saved = service.savePlataform(plataformEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(PlataformMapper.toPlataformResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlataform(@PathVariable Long id) {
        service.deletePlataform(id);
        return ResponseEntity.ok().build();
    }
}
