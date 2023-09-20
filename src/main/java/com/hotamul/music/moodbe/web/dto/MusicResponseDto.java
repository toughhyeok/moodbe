package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.music.Music;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MusicResponseDto {
    private Long id;
    private LocalDateTime createdDate;
    private String title;
    private String content;
    private String author;
    private String youtubeUrl;
    private String feat;
    private String imageName;

    public MusicResponseDto(Music music) {
        this.id = music.getId();
        this.createdDate = music.getCreatedDate();
        this.title = music.getTitle();
        this.content = music.getContent();
        this.author = music.getAuthor();
        this.youtubeUrl = music.getYoutubeUrl();
        this.feat = music.getFeat();
        this.imageName = music.getImageName();
    }
}
