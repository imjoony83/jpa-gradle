package com.github.imjoony83.jpagradle.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;

@Entity
@MappedSuperclass
@Table(name="coupons")
public class CustomerCoupon {
	
	@Builder
	public CustomerCoupon(long couponId, long customerId, LocalDateTime useDate) {
		this.couponId = couponId;
		this.customerId = customerId;
		this.useDate = useDate;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private long couponId;
	
	@Column(nullable=false)
	private long customerId;
	
	@Column(nullable=false, columnDefinition="varchar(255) default 'N'")
	private String isUsed;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime useDate;

}
