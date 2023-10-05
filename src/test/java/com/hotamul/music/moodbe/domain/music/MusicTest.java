package com.hotamul.music.moodbe.domain.music;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MusicTest {
    @Test
    public void isPublished_default_value_is_false() {
        Music music = Music.builder().build();
        Assertions.assertThat(music.isPublished()).isEqualTo(false);
    }
}
