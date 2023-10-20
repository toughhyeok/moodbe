package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.config.auth.dto.SessionUser;
import com.hotamul.music.moodbe.service.music.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MusicHtmlController {
    private final MusicService service;
    private final HttpSession httpSession;

    @GetMapping("/music/{id}")
    public String musicPage(@PathVariable Long id, Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        model.addAttribute("music", service.findById(id));

        if (user != null) {
            String email = user.getEmail();
            model.addAttribute("userName", email.substring(0, email.indexOf('@')));
            model.addAttribute("profileImageUrl", user.getPicture());
        }

        return "music";
    }
}
