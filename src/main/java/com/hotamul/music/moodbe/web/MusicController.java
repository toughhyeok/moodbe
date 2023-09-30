package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.service.music.MusicService;
import com.hotamul.music.moodbe.web.dto.MusicRegisterDto;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("music")
public class MusicController {
    private final MusicService service;

    @GetMapping("latest")
    public ResponseEntity<MusicResponseDto> getLatestMusic() {
        return ResponseEntity.ok(service.findLatest());
    }

    @GetMapping("all")
    public ResponseEntity<List<MusicResponseDto>> getAllMusic() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("register")
    public ResponseEntity<MusicResponseDto> registerMusic(@RequestBody MusicRegisterDto musicRegisterDto) {
        if (!musicRegisterDto.getImagePath().startsWith("https://moodbe-storage-2023.s3.ap-northeast-2.amazonaws.com/") ||
                !musicRegisterDto.getYoutubeUrl().startsWith("https://youtube.com/watch?v="))
            throw new IllegalArgumentException();
        return ResponseEntity.ok(service.register(musicRegisterDto));
    }
}
