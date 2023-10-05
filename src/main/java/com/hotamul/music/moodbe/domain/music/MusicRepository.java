package com.hotamul.music.moodbe.domain.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MusicRepository extends JpaRepository<Music, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM music m WHERE m.is_published = true ORDER BY m.id DESC LIMIT 1")
    Music findLatest();
}
