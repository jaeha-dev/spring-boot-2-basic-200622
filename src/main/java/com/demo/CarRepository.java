package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @title  : Car 레포지토리 인터페이스
 * @author : jaeha-dev (Git)
 * @memo   : @DataJpaTest를 위한 레포지토리 인터페이스
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}