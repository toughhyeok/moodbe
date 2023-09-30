package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.music.Music;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MusicRegisterDto {
    private final String author;
    private final String title;
    private final String content;
    private final String feat;
    private final String youtubeUrl;
    private final String imagePath;

    public Music toEntity() {
        return Music.builder()
                .author(this.author)
                .title(this.title)
                .content(this.content)
                .feat(this.feat)
                .youtubeUrl(this.imagePath)
                .imagePath(this.imagePath).build();
    }
}
