package com.hotamul.music.moodbe.web.dto;

import com.hotamul.music.moodbe.domain.comment.Reply;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {
    private final Long id;
    private final String whenCreated;
    private final String content;
    private final String author;
    private final String profileImageUrl;

    public ReplyResponseDto(Reply reply) {
        this.id = reply.getId();
        this.whenCreated = getTimeDifference(reply.getCreatedDate());
        this.content = reply.getContent();
        String email = reply.getUser().getEmail();
        this.author = email.substring(0, email.indexOf('@'));
        this.profileImageUrl = reply.getUser().getPicture();
    }

    private String getTimeDifference(LocalDateTime createdDate) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(createdDate, currentTime);

        long seconds = duration.getSeconds();

        if (seconds < 60) {
            return "방금 전에 작성됨";
        }
        if (seconds < 3600) {
            long minutes = seconds / 60;
            return minutes + "분 전에 작성됨";
        }
        if (seconds < 86400) {
            long hours = seconds / 3600;
            return hours + "시간 전에 작성됨";
        }
        long days = seconds / 86400;
        return days + "일 전에 작성됨";
    }
}
