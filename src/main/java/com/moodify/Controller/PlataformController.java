package com.moodify.Controller;

import com.moodify.Mapper.PlataformMapper;
import com.moodify.Model.Plataform;
import com.moodify.response.ContentsResponse;
import com.moodify.response.MoodsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name="Plataform",  description = "Recurso responsavel pelo gerenciamento das Plataformas")

public class PlataformController {
    private final PlataformService service;

    @Operation(summary = "Ver Plataformas", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = PlataformResponse.class))))
    @GetMapping
    public ResponseEntity<List<PlataformResponse>> listarTodasPlataformas() {
        List<Plataform> listAll = service.listAll();

        return ResponseEntity.ok(listAll.stream()
                .map(PlataformMapper::toPlataformResponse)
                .toList());
    }

    @Operation(summary = "Ver Plataforma por ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PlataformResponse.class)))
    @ApiResponse(responseCode = "404")
    @GetMapping("/{id}")
    public ResponseEntity<PlataformResponse> getPlataformId(@PathVariable Long id) {
        PlataformResponse plataformResponse = service.getPlataformId(id);
        if(plataformResponse != null){
            return ResponseEntity.ok(plataformResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Criar Plataforma", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = PlataformResponse.class)))
    @PostMapping
    public ResponseEntity<PlataformResponse> savePlataform(@Valid @RequestBody PlataformRequest plataformRequest) {
        Plataform plataformEntity = PlataformMapper.toPlataform(plataformRequest);
        Plataform saved = service.savePlataform(plataformEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(PlataformMapper.toPlataformResponse(saved));
    }

    @Operation(summary = "Deletar Plataforma", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlataform(@PathVariable Long id) {
        service.deletePlataform(id);
        return ResponseEntity.ok().build();
    }
}
