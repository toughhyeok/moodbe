package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.service.music.MusicService;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("music")
public class MusicController {
    private final MusicService service;

    @GetMapping("latest")
    public ResponseEntity<MusicResponseDto> getLatestMusic() {
        return ResponseEntity.ok(service.findLatest());
    }
}
