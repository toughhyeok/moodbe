package com.hotamul.music.moodbe.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReplySaveRequestDto {
    private String content;
    private Long musicId;

    @Builder
    public ReplySaveRequestDto(String content, Long musicId) {
        this.content = content;
        this.musicId = musicId;
    }
}
