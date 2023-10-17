package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.service.music.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class MusicHtmlController {
    private final MusicService service;

    @GetMapping("/music/{id}")
    public String musicPage(@PathVariable Long id, Model model) {
        model.addAttribute("music", service.findById(id));
        return "music";
    }
}
