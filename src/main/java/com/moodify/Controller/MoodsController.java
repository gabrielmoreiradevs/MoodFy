package com.moodify.Controller;

import com.moodify.Mapper.MoodsMapper;
import com.moodify.request.MoodsRequest;
import com.moodify.response.ContentsResponse;
import com.moodify.response.MoodsResponse;
import com.moodify.Model.Moods;
import com.moodify.Service.MoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moodfy/moods")
@RequiredArgsConstructor

@Tag(name = "Moods",  description = "Recurso responsavel pelo gerenciamento dos Moods/Humores")

public class MoodsController {

    private final MoodsService moodsService;

    @Operation(summary = "Ver Conteudos", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = MoodsResponse.class))))
    @GetMapping()
    public ResponseEntity<List<MoodsResponse>> listarTodosOsMoods(){
        List<Moods> list = moodsService.listarTodosOsMoods();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list.stream()
                .map(MoodsMapper::toMoodsResponse)
                .toList());
    }

    @Operation(summary = "Criar Humor", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = MoodsResponse.class)))
    @PostMapping
    public ResponseEntity<MoodsResponse> adicionarUmNovoMood(@Valid @RequestBody MoodsRequest moods){
        Moods mood =  MoodsMapper.toMoods(moods);
        Moods save = moodsService.addMood(mood);
        return ResponseEntity.status(HttpStatus.CREATED).body(MoodsMapper.toMoodsResponse(save));
    }

    @Operation(summary = "Ver Humor por ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = MoodsResponse.class)))
    @ApiResponse(responseCode = "404")
    @GetMapping("/{id}")
    public ResponseEntity<MoodsResponse> buscarMoodPorId(@PathVariable Long id){
        MoodsResponse moodsResponse = moodsService.buscarMoodPorId(id);

        if(moodsResponse != null){
            return ResponseEntity.status(HttpStatus.OK).body(moodsResponse);
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar Humor por ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMoodPorId(@PathVariable Long id){
        moodsService.deletarMood(id);
        return ResponseEntity.noContent().build();
    }

}
