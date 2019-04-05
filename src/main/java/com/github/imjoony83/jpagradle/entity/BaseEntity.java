package com.github.imjoony83.jpagradle.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private long id;

    //	@Column(nullable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Column(nullable=false)
    private LocalDateTime updateDate;

    @CreationTimestamp
    @Column(nullable=false)
    private LocalDateTime insertDate;

}
