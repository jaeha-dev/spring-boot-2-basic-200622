package com.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * @title  : Coffee 모델 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @RestClient 테스트를 위한 모델 클래스
 */
@Getter
@NoArgsConstructor
public class Coffee {
    private Integer idx;
    private String name;
    private LocalDateTime createdAt;

    @Builder
    public Coffee(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}