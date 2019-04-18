package com.github.imjoony83.jpagradle.constant;

import lombok.Getter;

public enum CouponStatus {

    USE("U"),
    NOTUSE("R"),
    VALID("Y"),
    INVALID("N");

    @Getter
    private String status;

    CouponStatus(String status) {
        this.status = status;
    }
}
