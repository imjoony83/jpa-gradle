package com.github.imjoony83.jpagradle.entity;

import com.github.imjoony83.jpagradle.constant.CouponStatus;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Entity
@Table(name="customerCoupon")
public class CustomerCoupon extends BaseEntity{
	
	@Builder
	public CustomerCoupon(Coupon coupon, Customer customer, CouponStatus status ) {
		this.coupontId = coupon;
		this.customerId = customer;
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name ="coupon_id")
	private Coupon coupontId;

	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customerId;

	@Setter
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private CouponStatus status;

	@UpdateTimestamp
	private LocalDateTime useDate;

	@Override
	public String toString() {
		return "CustomerCoupon{" +
				"coupontId=" + coupontId +
				", customerId=" + customerId +
				", status=" + status +
				", useDate=" + useDate +
				'}';
	}
}
