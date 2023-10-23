package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.config.auth.dto.SessionUser;
import com.hotamul.music.moodbe.service.reply.ReplyService;
import com.hotamul.music.moodbe.web.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {
    private final HttpSession httpSession;
    private final ReplyService replyService;

    @PostMapping("/api/v1/reply")
    public Long save(@RequestParam String content, Long musicId) {
        ReplySaveRequestDto requestDto = ReplySaveRequestDto.builder().musicId(musicId).content(content).build();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return replyService.save(requestDto, user);
    }
}
