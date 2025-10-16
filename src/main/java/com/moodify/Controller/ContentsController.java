package com.moodify.Controller;

import com.moodify.Mapper.ContentsMapper;
import com.moodify.Model.Contents;
import com.moodify.Service.ContentsService;
import com.moodify.request.ContentsRequest;
import com.moodify.response.ContentsResponse;
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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moodfy/contents")
@RequiredArgsConstructor
@Tag(name = "Contents", description = "Recurso responsavel pelo gerenciamento dos Conteudos")

public class ContentsController {
    private final ContentsService contentsService;

    @Operation(summary = "Criar Conteudo", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ContentsResponse.class)))
    @PostMapping
    public ResponseEntity<ContentsResponse> save(@Valid @RequestBody ContentsRequest contentsRequest) {
        Contents saved = contentsService.save(ContentsMapper.toContents(contentsRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(ContentsMapper.toContentsResponse(saved));
    }

    @Operation(summary = "Ver Conteudos", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = ContentsResponse.class))))
    @GetMapping
    public ResponseEntity<List<ContentsResponse>> findAll(){
        List<Contents> All = contentsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(All.stream()
                .map(list-> ContentsMapper.toContentsResponse(list))
                .toList());
    }

    @Operation(summary = "Ver Conteudos pelo Id", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ContentsResponse.class)))
    @ApiResponse(responseCode = "404")
    @GetMapping("/{id}")
    public ResponseEntity<ContentsResponse> findById(@PathVariable Long id){
        Optional<Contents> contents = contentsService.findById(id);
        if(contents.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ContentsMapper.toContentsResponse(contents.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Atualizar Conteudos pelo Id", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ContentsResponse.class)))
    @ApiResponse(responseCode = "404")
    @PutMapping("/{id}")
    public ResponseEntity<ContentsResponse> update(@Valid @RequestBody ContentsRequest contentsRequest, @PathVariable Long id) {
        return contentsService.update(ContentsMapper.toContents(contentsRequest),id)
                .map(contents -> ResponseEntity.ok(ContentsMapper.toContentsResponse(contents)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Achar Conteudo pelo Mood(Humor)", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = ContentsResponse.class))))
    @GetMapping("/search")
    public ResponseEntity<List<ContentsResponse>> findByMood(@RequestParam Long mood) {
        return ResponseEntity.ok(contentsService.findByContentsInContents(mood)
                .stream()
                .map(ContentsMapper::toContentsResponse)
                .toList());
    }

    @Operation(summary = "Deletar Conteudos pelo Id", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
