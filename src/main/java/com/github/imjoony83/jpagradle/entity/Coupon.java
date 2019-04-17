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

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;

@Entity
@Table(name="coupon")
public class Coupon extends BaseEntity {

	@Builder
	public Coupon(String name, LocalDate expireDate) {
		this.name = name;
		this.expireDate = expireDate;
	}
	
//	@Id
//	@GeneratedValue
//	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, columnDefinition="char(1) default 'Y'")
	private boolean valid;
	
	@Column(nullable=false)
	private LocalDate expireDate;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "coupontId")
	private Collection<CustomerCoupon> coupons;
	
}
