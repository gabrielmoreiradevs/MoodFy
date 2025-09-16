package com.moodify.Controller;

import com.moodify.Service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moodfy/contents")
@RequiredArgsConstructor
public class ContentsController {
    private final ContentsService contentsService;

}
