package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.service.music.MusicService;
import com.hotamul.music.moodbe.web.dto.MusicRegisterDto;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<MusicResponseDto> registerMusic(@RequestParam("author") String author, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("file") MultipartFile file, @RequestParam("feat") String feat, @RequestParam("youtubeUrl") String youtubeUrl) throws FileUploadException {
        MusicRegisterDto musicRegisterDto = new MusicRegisterDto(author, title, content, feat, youtubeUrl, file);
        if (!musicRegisterDto.getYoutubeUrl().startsWith("https://youtube.com/watch?v="))
            throw new IllegalArgumentException();
        try {
            return ResponseEntity.ok(service.register(musicRegisterDto));
        } catch (IOException e) {
            throw new FileUploadException(e);
        }
    }
}
