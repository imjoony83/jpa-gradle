package com.github.imjoony83.jpagradle.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Builder;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="customerCoupon")
public class CustomerCoupon extends  BaseEntity{
	
	@Builder
	public CustomerCoupon(Coupon coupon, Customer customer, LocalDateTime useDate) {
		this.coupontId = coupon;
		this.customerId = customer;
		this.useDate = useDate;
	}

	@ManyToOne
	@JoinColumn(name ="coupon_id")
	private Coupon coupontId;

	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customerId;

	@Column(nullable=false, columnDefinition="varchar(255) default 'N'")
	private String used;

	@UpdateTimestamp
	private LocalDateTime useDate;

}
