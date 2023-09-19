package com.hotamul.music.moodbe.domain.music;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MusicRepositoryTest {
    @Autowired
    MusicRepository musicRepository;

    @Test
    public void save_Music_and_findAll() {
        Music music = Music.builder()
                .title("Blanc")
                .content("This Song is Good!!")
                .author("ADOY")
                .feat("George")
                .imageName("adoy_blanc")
                .youtubeUrl("http://test.com").build();
        musicRepository.save(music);
        Assertions.assertThat(musicRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    public void findAll_should_be_return_empty_when_insert_never_executed() {
        Assertions.assertThat(musicRepository.findAll()).isEmpty();
    }

    @Test
    public void createdDate_check() {
        musicRepository.save(Music.builder()
                .title("Blanc")
                .content("This Song is Good!!")
                .author("ADOY")
                .feat("George")
                .imageName("adoy_blanc")
                .youtubeUrl("http://test.com").build());
        Music music = musicRepository.findAll().get(0);
        Assertions.assertThat(music.getCreatedDate()).isNotNull();
    }
}
