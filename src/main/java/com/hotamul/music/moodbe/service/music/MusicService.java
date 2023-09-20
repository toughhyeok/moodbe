package com.hotamul.music.moodbe.service.music;

import com.hotamul.music.moodbe.domain.music.MusicRepository;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicResponseDto findLatest() {
        return new MusicResponseDto(musicRepository.findLatest());
    }
}
