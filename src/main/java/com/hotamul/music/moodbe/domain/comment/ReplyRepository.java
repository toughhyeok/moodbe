package com.hotamul.music.moodbe.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByMusicIdOrderByCreatedDateAsc(Long musicId);
}
