package com.github.imjoony83.jpagradle.listener;

import com.github.imjoony83.jpagradle.entity.Customer;
import com.github.imjoony83.jpagradle.repository.CouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerCouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerJpaRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@RequiredArgsConstructor
@Component
public class InitDemoDataListener implements ApplicationListener<ApplicationReadyEvent> {

    private final CouponJpaRepository couponJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerCouponJpaRepository customerCouponJpaRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // TODO Auto-generated method stub

        // add Customer
        Faker faker = new Faker();
        // faker.name();

        Arrays.asList(faker.name(), faker.name(), faker.name()).stream().forEach(name -> {
//            Customer customer - Customer.
//            Customer customer = Customer.builder().name(name).email(name + "@mail.com").grade(0).build();
//            customerJpaRepository.save(customer);
        });

        // add Coupon

        // add CustomerCoupon


    }

}
