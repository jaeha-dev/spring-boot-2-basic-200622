package com.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @title  : 프로퍼티 읽기 테스트
 * @author : jaeha-dev (Git)
 * @memo   : @ConfigurationProperties 테스트를 위한 바인딩 클래스
 */
@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
    // Map 타입보다는
    // private List<Map> list;

    // POJO 타입을 사용하는 것이 더 명확하다.
    private List<Fruit> list;
}