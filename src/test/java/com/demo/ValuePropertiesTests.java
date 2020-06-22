package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

/**
 * @title  : 프로퍼티 읽기 테스트
 * @author : jaeha-dev (Git)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValuePropertiesTests {

    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyTest}")
    private String propertyTest;

    // YAML 파일에 키 값이 없을 경우 기본 값이 매핑되도록 지정한다.
    @Value("${noKey:default value}")
    private String defaultValue;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    // SpEL을 사용하여 ','를 기준으로 List에 매핑한다.
    // propertyTestList의 각 요소는 a,b,c이므로 구분자는 콤마 문자로 지정한다.
    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;

    @Test
    public void testValue() {
        assertThat(propertyTestName).isEqualTo("property depth test");
        assertThat(propertyTest).isEqualTo("test");
        assertThat(defaultValue).isEqualTo("default value");

        assertThat(propertyTestArray[0]).isEqualTo("a");
        assertThat(propertyTestArray[1]).isEqualTo("b");
        assertThat(propertyTestArray[2]).isEqualTo("c");

        assertThat(propertyTestList.get(0)).isEqualTo("a");
        assertThat(propertyTestList.get(1)).isEqualTo("b");
        assertThat(propertyTestList.get(2)).isEqualTo("c");
    }
}