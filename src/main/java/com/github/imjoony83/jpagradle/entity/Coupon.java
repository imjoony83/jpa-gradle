package com.github.imjoony83.jpagradle.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@MappedSuperclass
@Table(name="coupon")
public class Coupon {

	@Builder
	public Coupon(String name, LocalDate expireDate) {
		this.name = name;
		this.expireDate = expireDate;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, columnDefinition="char(1) default 'Y'")
	private boolean isValid;
	
//	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@Column(nullable=false)
	private LocalDateTime updateDate;
	
	@Column(nullable=false)
	private LocalDateTime insertDate;
	
	@Column(nullable=false)
	private LocalDate expireDate;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="couponId")
	private Collection<CustomerCoupon> coupons;
	
}
