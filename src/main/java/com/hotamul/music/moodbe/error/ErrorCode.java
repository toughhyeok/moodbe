package com.hotamul.music.moodbe.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_URL_PARAMETER(HttpStatus.BAD_REQUEST, "유효하지 않은 URL입니다."),
    MAX_FILE_SIZE_OVER(HttpStatus.BAD_REQUEST, "파일 크기를 확인하세요.");

    private final HttpStatus httpStatus;
    private final String message;
}
