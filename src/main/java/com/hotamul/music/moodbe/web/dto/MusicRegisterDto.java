package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.music.Music;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class MusicRegisterDto {
    private final String author;
    private final String title;
    private final String content;
    private final String feat;
    private final String youtubeUrl;
    private final MultipartFile file;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private String imagePath;


    public Music toEntity() {
        if (this.imagePath == null) throw new NullPointerException();
        return Music.builder()
                .author(this.author)
                .title(this.title)
                .content(this.content)
                .feat(this.feat)
                .youtubeUrl(this.youtubeUrl)
                .imagePath(this.imagePath).build();
    }
}
