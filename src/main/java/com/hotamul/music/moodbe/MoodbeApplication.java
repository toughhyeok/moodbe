package com.hotamul.music.moodbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MoodbeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoodbeApplication.class, args);
    }

}
