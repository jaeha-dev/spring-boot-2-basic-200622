package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title  : Coffee 컨트롤러 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @RestClient 테스트를 위한 컨트롤러 클래스
 */
@RestController
public class CoffeeRestController {

    @Autowired
    private CoffeeRestService coffeeRestService;

    @GetMapping(path = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee getRestCoffee() {
        return coffeeRestService.getRestCoffee();
    }
}