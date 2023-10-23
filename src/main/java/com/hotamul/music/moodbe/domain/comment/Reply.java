package com.hotamul.music.moodbe.domain.comment;

import com.hotamul.music.moodbe.domain.BaseTimeEntity;
import com.hotamul.music.moodbe.domain.music.Music;
import com.hotamul.music.moodbe.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "REPLY")
public class Reply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musicId")
    private Music music;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Reply(Music music, User user, String content) {
        this.music = music;
        this.user = user;
        this.content = content;
    }
}
