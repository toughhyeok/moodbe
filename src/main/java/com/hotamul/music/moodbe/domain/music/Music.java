package com.hotamul.music.moodbe.domain.music;

import com.hotamul.music.moodbe.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MUSIC")
public class Music extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 500, nullable = false)
    private String author;

    @Column(length = 500, nullable = false)
    private String youtubeUrl;

    @Column(length = 500)
    private String feat;

    @Column(length = 500, nullable = false)
    private String imagePath;

    @ColumnDefault("false")
    private boolean isPublished = false;

    @Builder
    public Music(String title, String content, String author, String youtubeUrl, String feat, String imagePath, boolean isPublished) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.youtubeUrl = youtubeUrl;
        this.feat = feat;
        this.imagePath = imagePath;
        this.isPublished = isPublished;
    }
}
