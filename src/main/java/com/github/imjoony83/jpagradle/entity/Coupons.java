package com.github.imjoony83.jpagradle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
public class Coupons {
	
	@Builder
	public Coupons(long coupon_id, long customer_id, Date is_use_date) {
		this.coupon_id = coupon_id;
		this.customer_id = customer_id;
		this.is_use_date = is_use_date;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private long coupon_id;
	
	@Column(nullable=false)
	private long customer_id;
	
	@Column(nullable=false, columnDefinition="varchar(255) default 'N'")
	private String is_used;
	
	private Date is_use_date;

}
