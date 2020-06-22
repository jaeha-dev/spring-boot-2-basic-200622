package com.demo;

import jdk.vm.ci.meta.Local;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @title  : Car 모델 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @DataJpaTest를 위한 모델 클래스
 */
@Getter
@NoArgsConstructor
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private String name;

    @Column
    private LocalDateTime manufacturedAt;

    @Builder
    public Car(String name, LocalDateTime manufacturedAt) {
        this.name = name;
        this.manufacturedAt = manufacturedAt;
    }
}