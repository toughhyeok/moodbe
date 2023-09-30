package com.hotamul.music.moodbe.service.music;

import com.hotamul.music.moodbe.domain.music.Music;
import com.hotamul.music.moodbe.domain.music.MusicRepository;
import com.hotamul.music.moodbe.web.dto.MusicRegisterDto;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicResponseDto findLatest() {
        return new MusicResponseDto(musicRepository.findLatest());
    }

    public List<MusicResponseDto> findAll() {
        return musicRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().map(MusicResponseDto::new).collect(Collectors.toList());
    }

    public MusicResponseDto register(MusicRegisterDto musicRegisterDto) {
        Music music = musicRegisterDto.toEntity();
        musicRepository.save(music);
        return new MusicResponseDto(music);
    }
}
