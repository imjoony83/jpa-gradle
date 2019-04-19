package com.github.imjoony83.jpagradle;


import com.github.imjoony83.jpagradle.constant.CouponStatus;
import com.github.imjoony83.jpagradle.entity.Coupon;
import com.github.imjoony83.jpagradle.entity.Customer;
import com.github.imjoony83.jpagradle.entity.CustomerCoupon;
import com.github.imjoony83.jpagradle.repository.CouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerCouponJpaRepository;
import com.github.imjoony83.jpagradle.repository.CustomerJpaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan("com.github.imjoony83.jpagradle")
@EnableJpaRepositories("com.github.imjoony83.jpagradle.repository")
@EnableTransactionManagement
public class CustomerCouponTests {

    final Logger logger = LoggerFactory.getLogger(CustomerCouponTests.class);

    @Resource
    private CouponJpaRepository couponJpaRepository;
    @Resource
    private CustomerJpaRepository customerJpaRepository;
    @Resource
    private CustomerCouponJpaRepository customerCouponJpaRepository;

    @Test
    public void 쿠폰사용테스트() {

        long customerId = 1L;
        long couponId = 5L;
        Customer customer = customerJpaRepository.findById(customerId);
        if (Objects.isNull(customer)) {
            Assert.fail("customer is null");
        }

        Coupon coupon = couponJpaRepository.findById(couponId);
        if (Objects.isNull(coupon)) {
            Assert.fail("coupon is null");
        }

        CustomerCoupon customerCoupon = customerCouponJpaRepository.findByCustomerIdAndCoupontId(customer, coupon);

        if (Objects.isNull(customerCoupon)) {
            Assert.fail("customerCoupon is null");
        }

        System.out.println("before : "  + customerCoupon.toString());

        customerCoupon.setStatus(CouponStatus.USE);
        customerCouponJpaRepository.flush();

        System.out.println("after : " + customerCoupon.toString());

    }
}
