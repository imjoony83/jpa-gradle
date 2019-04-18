package com.github.imjoony83.jpagradle.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.imjoony83.jpagradle.constant.CouponStatus;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Table(name="coupon")
public class Coupon extends BaseEntity {

	@Builder
	public Coupon(String name, LocalDate expireDate, CouponStatus status) {
		this.name = name;
		this.expireDate = expireDate;
		this.status = status;
	}
	
//	@Id
//	@GeneratedValue
//	private long id;
	
	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private CouponStatus status;
	
	@Column(nullable=false)
	private LocalDate expireDate;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "coupontId")
	private Collection<CustomerCoupon> coupons;
	
}
