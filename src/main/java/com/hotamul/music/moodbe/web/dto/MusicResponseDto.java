package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.music.Music;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
//@NoArgsConstructor
public class MusicResponseDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String title;
    private String content;
    private String author;
    private String youtubeUrl;
    private String feat;
    private String imagePath;

    public MusicResponseDto(Music music) {
        this.id = music.getId();
        this.createdDate = music.getCreatedDate();
        this.modifiedDate = music.getModifiedDate();
        this.title = music.getTitle();
        this.content = music.getContent();
        this.author = music.getAuthor();
        this.youtubeUrl = music.getYoutubeUrl();
        this.feat = music.getFeat();
        this.imagePath = music.getImagePath();
    }
}
