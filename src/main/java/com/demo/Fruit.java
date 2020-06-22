package com.demo;

import lombok.Data;

/**
 * @title  : 프로퍼티 읽기 테스트
 * @author : jaeha-dev (Git)
 * @memo   : @ConfigurationProperties 테스트를 위한 모델 클래스
 */
@Data
public class Fruit {
    private String name;
    private String color;
}