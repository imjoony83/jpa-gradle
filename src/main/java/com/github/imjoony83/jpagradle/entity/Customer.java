package com.github.imjoony83.jpagradle.entity;

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
@Table(name="customer")
public class Customer extends BaseEntity{
	
	@Builder
	public Customer(String email, String name, int grade) {
		this.email = email;
		this.name = name;
		this.grade = grade;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String email;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, columnDefinition="int default 0")
	private int grade;
	
//	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
//	private LocalDateTime updateDate;
//
//	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
//	private LocalDateTime insertDate;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="customerId")
	private Collection<CustomerCoupon> customerCoupons;

}
