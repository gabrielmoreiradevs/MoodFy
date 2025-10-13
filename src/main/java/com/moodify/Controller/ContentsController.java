package com.moodify.Controller;

import com.moodify.Mapper.ContentsMapper;
import com.moodify.Model.Contents;
import com.moodify.Service.ContentsService;
import com.moodify.request.ContentsRequest;
import com.moodify.response.ContentsResponse;
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

public class ContentsController {
    private final ContentsService contentsService;

    @PostMapping
    public ResponseEntity<ContentsResponse> save(@Valid @RequestBody ContentsRequest contentsRequest) {
        Contents saved = contentsService.save(ContentsMapper.toContents(contentsRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(ContentsMapper.toContentsResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<ContentsResponse>> findAll(){
        List<Contents> All = contentsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(All.stream()
                .map(list-> ContentsMapper.toContentsResponse(list))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentsResponse> findById(@PathVariable Long id){
        Optional<Contents> contents = contentsService.findById(id);
        if(contents.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ContentsMapper.toContentsResponse(contents.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentsResponse> update(@Valid @RequestBody ContentsRequest contentsRequest, @PathVariable Long id) {
        return contentsService.update(ContentsMapper.toContents(contentsRequest),id)
                .map(contents -> ResponseEntity.ok(ContentsMapper.toContentsResponse(contents)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContentsResponse>> findByMood(@RequestParam Long mood) {
        return ResponseEntity.ok(contentsService.findByContentsInContents(mood)
                .stream()
                .map(ContentsMapper::toContentsResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
