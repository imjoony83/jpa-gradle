package com.github.imjoony83.jpagradle.repository;

import com.github.imjoony83.jpagradle.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

}
