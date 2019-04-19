package com.github.imjoony83.jpagradle.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    @Getter
    private long id;

    //	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Column(nullable=false)
    private LocalDateTime updateDate;

    @CreationTimestamp
    @Column(nullable=false)
    private LocalDateTime insertDate;

}
