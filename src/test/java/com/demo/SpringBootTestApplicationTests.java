package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

/**
 * @title  : @SpringBootTest
 * @author : jaeha-dev (Git)
 * @memo   : 통합 테스트를 제공하는 어노테이션으로 실제 구동되는 앱과 동일하게
 *           앱에 설정된 빈을 모두 로드하므로 앱 규모가 클수록 느려진다.
 * @memo   : 프로파일 환경 지정은 @ActiveProfiles("local") 등의 방식을 사용한다.
 * @memo   : 테스트 시 @Transactional을 사용하면 테스트 후 데이터가 롤백된다.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
                value = "value=test", // 프로퍼티 주입 (properties 옵션과 동시적용 불가능)
                // properties = {"property.value=propertyTest"}, // 키-값 형식으로 프로퍼티 추가 (value 옵션과 동시적용 불가능)
                classes = {DemoApplication.class}, // 앱 컨텍스트에 로드할 클래스 지정
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 앱 실행 시 웹 환경 설정
public class SpringBootTestApplicationTests {

    @Value("${value}")
    private String value;

    @Test
    public void contextLoadValue() {
        assertThat(value).isEqualTo("test");
    }

//    @Value("${property.value}")
//    private String propertyValue;
//
//    @Test
//    public void contextLoadProperty() {
//        assertThat(propertyValue).isEqualTo("propertyTest");
//    }
}