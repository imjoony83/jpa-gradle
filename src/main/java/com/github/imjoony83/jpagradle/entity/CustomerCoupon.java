package com.github.imjoony83.jpagradle.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.persistence.*;

import com.github.imjoony83.jpagradle.constant.CouponStatus;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

@RequiredArgsConstructor
@Entity
@Table(name="customerCoupon")
public class CustomerCoupon extends BaseEntity{
	
	@Builder
	public CustomerCoupon(Coupon coupon, Customer customer, CouponStatus status ) {
		this.coupontId = coupon;
		this.customerId = customer;
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name ="coupon_id")
	private Coupon coupontId;

	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customerId;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private CouponStatus status;

	@UpdateTimestamp
	private LocalDateTime useDate;

}
