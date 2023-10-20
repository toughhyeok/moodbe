package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.config.auth.dto.SessionUser;
import com.hotamul.music.moodbe.service.music.MusicService;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Controller
public class IndexHtmlController {
    private final MusicService musicService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        List<MusicResponseDto> allMusic = musicService.findIsPublished();
        model.addAttribute("allMusic", allMusic);

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            String email = user.getEmail();
            model.addAttribute("userName", email.substring(0, email.indexOf('@')));
            model.addAttribute("profileImageUrl", user.getPicture());
        }

        return "index";
    }
}
