package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

/**
 * @title  : @DataJpaTest
 * @author : jaeha-dev (Git)
 * @memo   : @JdbcTest, @DataMongoTest 등 존재
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTestCarJpaTests {
    private static final String BOOT_TEST_NAME = "Spring Boot Test Car";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void Car_저장_테스트() {
        Car car = Car.builder().name(BOOT_TEST_NAME).manufacturedAt(LocalDateTime.now()).build();
        testEntityManager.persist(car);

        assertThat(carRepository.getOne(car.getIdx())).isEqualTo(car);
    }

    @Test
    public void CarList_저장_검색_테스트() {
        Car car1 = Car.builder().name(BOOT_TEST_NAME + "1").manufacturedAt(LocalDateTime.now()).build();
        Car car2 = Car.builder().name(BOOT_TEST_NAME + "2").manufacturedAt(LocalDateTime.now()).build();
        Car car3 = Car.builder().name(BOOT_TEST_NAME + "3").manufacturedAt(LocalDateTime.now()).build();
        testEntityManager.persist(car1);
        testEntityManager.persist(car2);
        testEntityManager.persist(car3);

        List<Car> carList = carRepository.findAll();
        assertThat(carList).hasSize(3);
        assertThat(carList).contains(car1, car2, car3);
    }

    @Test
    public void CarList_저장_삭제_테스트() {
        Car car1 = Car.builder().name(BOOT_TEST_NAME + "1").manufacturedAt(LocalDateTime.now()).build();
        Car car2 = Car.builder().name(BOOT_TEST_NAME + "2").manufacturedAt(LocalDateTime.now()).build();
        Car car3 = Car.builder().name(BOOT_TEST_NAME + "3").manufacturedAt(LocalDateTime.now()).build();
        testEntityManager.persist(car1);
        testEntityManager.persist(car2);
        testEntityManager.persist(car3);

        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();
    }
}