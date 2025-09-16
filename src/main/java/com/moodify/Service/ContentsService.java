package com.moodify.Service;

import com.moodify.Repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;
}
