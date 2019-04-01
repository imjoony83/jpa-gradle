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
public class Customer {
	
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
	
	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date updateDate;
	
	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date insertDate;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Collection<Coupons> coupons;
	
}
