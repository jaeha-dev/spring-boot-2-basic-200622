package com.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @title  : Coffee 서비스 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @RestClient 테스트를 위한 서비스 클래스
 */
@Service
public class CoffeeRestService {
    private final RestTemplate restTemplate;

    public CoffeeRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("/rest/test").build();
    }

    public Coffee getRestCoffee() {
        return this.restTemplate.getForObject("/rest/test", Coffee.class);
    }
}