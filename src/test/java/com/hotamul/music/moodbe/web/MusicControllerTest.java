package com.hotamul.music.moodbe.web;

import com.hotamul.music.moodbe.domain.music.Music;
import com.hotamul.music.moodbe.domain.music.MusicRepository;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class MusicControllerTest {
    static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MusicRepository musicRepository;

    @AfterEach
    public void tearDown() {
        musicRepository.deleteAll();
    }

    private void createMusic(String title, String content, String author, String feat, String imagePath, String youtubeUrl, boolean isPublished) {
        musicRepository.save(Music.builder()
                .title(title)
                .content(content)
                .author(author)
                .feat(feat)
                .imagePath(imagePath)
                .youtubeUrl(youtubeUrl)
                .isPublished(isPublished).build());
    }

    @Test
    public void getLatestMusic_SHOULD_RETURN_status_200_WHENEVER() {
        createMusic("Blanc", "This Song is Good!", "ADOY", "George", "http://test.com", "http://test.com", true);

        ResponseEntity<MusicResponseDto> response = restTemplate.getForEntity("/music/latest", MusicResponseDto.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getAllMusic_SHOULD_RETURN_music_list_order_by_id_desc() {
        createMusic("Blanc", "This Song is Good!", "ADOY", "George", "http://test.com", "http://test.com", true);
        createMusic("애국가", "동해물과 백두산이", "안익태", null, "http://test.com", "http://test.com", true);

        ResponseEntity<List<MusicResponseDto>> response = restTemplate.exchange("/music/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<MusicResponseDto>>() {
        });
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<MusicResponseDto> allMusic = response.getBody();
        Assertions.assertThat(allMusic.get(0).getId() > allMusic.get(1).getId()).isTrue();
    }

}
