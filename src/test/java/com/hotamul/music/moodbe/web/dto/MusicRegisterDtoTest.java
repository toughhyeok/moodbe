package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.music.Music;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MusicRegisterDtoTest {
    @Test
    public void toEntity_SHOULD_return_Music_class_() {
        MusicRegisterDto musicRegisterDto = new MusicRegisterDto("안익태", "애국가", "동해물과 백두산이", null, "http://test.com", null);
        musicRegisterDto.setImagePath("http://test.com");
        Music musicEntity = musicRegisterDto.toEntity();
        Assertions.assertThat(musicEntity).isNotNull();
    }
}
