package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

/**
 * @title  : @JsonTest
 * @author : jaeha-dev (Git)
 * @memo   : JacksonTester DI가 안되는 문제로 문서를 참고하여 수정함
 *           (https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/json/JacksonTester.html)
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JsonTestMovieTests {

    private JacksonTester<Movie> json;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void json_테스트() throws Exception {
        Movie movie = Movie.builder().name("테스트").build();
        String content = "{\"name\":\"테스트\"}";

        // 문자열(content)을 객체로 변환하여 테스트
        assertThat(this.json.parseObject(content).getName()).isEqualTo(movie.getName());
        assertThat(this.json.parseObject(content).getCreatedAt()).isNull();

        // 객체(movie)를 JSON으로 변환하여 테스트
        // 각 필드를 변환한 문자열이 test.json 파일과 일치하는지 확인
        assertThat(this.json.write(movie)).isEqualToJson("/test.json");
        // name 키가 있는지 확인
        assertThat(this.json.write(movie)).hasJsonPathStringValue("name");
        // name 키의 값이 테스트인지 확인
        assertThat(this.json.write(movie)).extractingJsonPathStringValue("name").isEqualTo("테스트");
    }
}