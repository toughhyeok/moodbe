package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.service.music.MusicService;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Controller
public class IndexHtmlController {
    private final MusicService musicService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("musicIndexArray", IntStream.range(0, musicService.findIsPublished().size()).toArray());
        List<MusicResponseDto> allMusic = musicService.findIsPublished();
        model.addAttribute("allMusic", allMusic);

        return "index";
    }
}
