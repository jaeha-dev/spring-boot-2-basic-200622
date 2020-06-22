package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;

/**
 * @title  : 프로퍼티 읽기 테스트
 * @author : jaeha-dev (Git)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationPropertiesTests {

    @Autowired
    FruitProperty fruitProperty;

    @Test
    public void test() {
        // List<Map> fruitData = fruitProperty.getList();

        // assertThat(fruitData.get(0).get("name")).isEqualTo("apple");
        // assertThat(fruitData.get(0).get("color")).isEqualTo("red");
        // assertThat(fruitData.get(1).get("name")).isEqualTo("banana");
        // assertThat(fruitData.get(1).get("color")).isEqualTo("yellow");
        // assertThat(fruitData.get(2).get("name")).isEqualTo("melon");
        // assertThat(fruitData.get(2).get("color")).isEqualTo("green");

        List<Fruit> fruitData = fruitProperty.getList();
        assertThat(fruitData.get(0).getName()).isEqualTo("apple");
        assertThat(fruitData.get(0).getColor()).isEqualTo("red");
        assertThat(fruitData.get(1).getName()).isEqualTo("banana");
        assertThat(fruitData.get(1).getColor()).isEqualTo("yellow");
        assertThat(fruitData.get(2).getName()).isEqualTo("melon");
        assertThat(fruitData.get(2).getColor()).isEqualTo("green");
    }
}