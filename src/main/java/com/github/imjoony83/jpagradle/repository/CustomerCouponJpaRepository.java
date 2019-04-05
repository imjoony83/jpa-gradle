package com.github.imjoony83.jpagradle.repository;

import com.github.imjoony83.jpagradle.entity.CustomerCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCouponJpaRepository extends JpaRepository<CustomerCoupon, Long> {

}
