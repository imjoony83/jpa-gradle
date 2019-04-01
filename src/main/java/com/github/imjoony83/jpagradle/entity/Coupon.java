package com.github.imjoony83.jpagradle.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
public class Coupon {

	@Builder
	public Coupon(String name, Date expire_date) {
		this.name = name;
		this.expire_date = expire_date;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, columnDefinition="char(1) default 'Y'")
	private boolean isValid;
	
	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date update_date;
	
	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date insert_date;
	
	@Column(nullable=false, columnDefinition="timestamp default CURRENT_DATE")
	private Date expire_date;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="coupon_id")
	private Collection<Coupons> coupons;
	
}
