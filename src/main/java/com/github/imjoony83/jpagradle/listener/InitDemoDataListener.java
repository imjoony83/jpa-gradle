package com.github.imjoony83.jpagradle.listener;

import com.github.imjoony83.jpagradle.constant.CouponStatus;
import com.github.imjoony83.jpagradle.constant.GradeType;
import com.github.imjoony83.jpagradle.entity.Coupon;
import com.github.imjoony83.jpagradle.entity.Customer;
import com.github.imjoony83.jpagradle.entity.CustomerCoupon;
import com.github.imjoony83.jpagradle.repository.CouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerCouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDemoDataListener implements ApplicationListener<ApplicationReadyEvent> {

    final Logger logger = LoggerFactory.getLogger(InitDemoDataListener.class);

    private final CouponJpaRepository couponJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerCouponJpaRepository customerCouponJpaRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // add Customers
        Stream.of("customer_1", "customer_2", "customer_3").forEach(name -> {
            Customer customer = Customer.builder().name(name).email(name + "@mail.com").gradeType(GradeType.LEVEL_1).build();
            customerJpaRepository.save(customer);
        });

        // add Coupons
        Stream.of("coupon_1", "coupon_2").forEach(couponName-> {
            Coupon coupon = Coupon.builder().name(couponName).expireDate(LocalDate.now().plusDays(1)).status(CouponStatus.VALID).build();
            couponJpaRepository.save(coupon);
        });

        // add CustomerCoupons
        Collection<Customer> customers = customerJpaRepository.findAll();
        Collection<Coupon> coupons = couponJpaRepository.findAll();

        final BiConsumer<Collection<Customer>, Coupon> makeCustomerCoupons = (customersCollection, coupon) -> {
            customersCollection.forEach(customer -> {
                CustomerCoupon customerCoupon = CustomerCoupon.builder().coupon(coupon).customer(customer).status(CouponStatus.NOTUSE).build();
                customerCouponJpaRepository.save(customerCoupon);
            });
        };

        coupons.forEach(coupon-> makeCustomerCoupons.accept(customers, coupon) );
    }

}
