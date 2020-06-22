package com.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * @title  : Book 모델 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @WebMvcTest를 위한 모델 클래스
 */
@Getter
@NoArgsConstructor
public class Book {
    private Integer idx;
    private String title;
    private LocalDateTime publishedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt) {
        this.title = title;
        this.publishedAt = publishedAt;
    }
}