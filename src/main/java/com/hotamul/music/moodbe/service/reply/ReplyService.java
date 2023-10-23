package com.hotamul.music.moodbe.service.reply;

import com.hotamul.music.moodbe.config.auth.dto.SessionUser;
import com.hotamul.music.moodbe.domain.comment.Reply;
import com.hotamul.music.moodbe.domain.comment.ReplyRepository;
import com.hotamul.music.moodbe.domain.music.Music;
import com.hotamul.music.moodbe.domain.music.MusicRepository;
import com.hotamul.music.moodbe.domain.user.User;
import com.hotamul.music.moodbe.domain.user.UserRepository;
import com.hotamul.music.moodbe.web.dto.ReplyResponseDto;
import com.hotamul.music.moodbe.web.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final MusicRepository musicRepository;
    private final UserRepository userRepository;

    public Long save(ReplySaveRequestDto requestDto, SessionUser sessionUser) {
        Music music = musicRepository.findById(requestDto.getMusicId()).orElseThrow(InvalidParameterException::new);
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow(InvalidParameterException::new);
        Reply reply = Reply.builder()
                .content(requestDto.getContent())
                .music(music)
                .user(user).build();
        return replyRepository.save(reply).getId();
    }

    public List<ReplyResponseDto> findByMusicId(Long musicId) {
        return replyRepository.findByMusicIdOrderByCreatedDateAsc(musicId).stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }
}
