package com.github.imjoony83.jpagradle.entity;

import java.util.Collection;
import javax.persistence.*;

import com.github.imjoony83.jpagradle.constant.GradeType;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Table(name="customer")
public class Customer extends BaseEntity{
	
	@Builder
	public Customer(String email, String name, GradeType gradeType) {
		this.email = email;
		this.name = name;
		this.gradeType = gradeType;
	}
	
//	@Id
//	@GeneratedValue
//	private long id;
	
	@Column(unique=true)
	private String email;
	
	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private GradeType gradeType;
	
//	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
//	private LocalDateTime updateDate;
//
//	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
//	private LocalDateTime insertDate;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customerId")
	private Collection<CustomerCoupon> customerCoupons;

}
