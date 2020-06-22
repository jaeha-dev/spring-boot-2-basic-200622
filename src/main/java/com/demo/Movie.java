package com.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * @title  : Movie 모델 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @JsonTest를 위한 모델 클래스
 */
@Getter
@NoArgsConstructor
public class Movie {
    private Integer idx;
    private String name;
    private LocalDateTime createdAt;

    @Builder
    public Movie(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}