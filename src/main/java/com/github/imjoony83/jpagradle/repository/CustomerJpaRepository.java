package com.github.imjoony83.jpagradle.repository;

import com.github.imjoony83.jpagradle.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

}
