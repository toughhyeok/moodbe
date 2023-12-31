package com.hotamul.music.moodbe.domain.music;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application-test.properties")
public class MusicRepositoryTest {
//    static {
//        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
//    }
//
//    @Autowired
//    MusicRepository musicRepository;
//
//    @Test
//    public void save_Music_and_findAll() {
//        Music music = Music.builder().title("Blanc").content("This Song is Good!!").author("ADOY").feat("George").imagePath("http://adoy_blanc.jpg").youtubeUrl("http://test.com").build();
//        musicRepository.save(music);
//        Assertions.assertThat(musicRepository.findAll().size()).isEqualTo(1);
//    }
//
//    @Test
//    public void findAll_should_be_return_empty_when_insert_never_executed() {
//        Assertions.assertThat(musicRepository.findAll()).isEmpty();
//    }
//
//    @Test
//    public void createdDate_check() {
//        musicRepository.save(Music.builder().title("Blanc").content("This Song is Good!!").author("ADOY").feat("George").imagePath("http://adoy_blanc.jpg").youtubeUrl("http://test.com").isPublished(true).build());
//        Music music = musicRepository.findAll().get(0);
//        Assertions.assertThat(music.getCreatedDate()).isNotNull();
//    }
//
//    @Test
//    public void findLatest_should_return_one_Music() {
//        musicRepository.save(Music.builder().title("Blanc").content("This Song is Good!!").author("ADOY").feat("George").imagePath("http://adoy_blanc.jpg").youtubeUrl("http://test.com").isPublished(true).build());
//        Music music = musicRepository.findLatest();
//        Assertions.assertThat(music).isNotNull();
//    }
}
