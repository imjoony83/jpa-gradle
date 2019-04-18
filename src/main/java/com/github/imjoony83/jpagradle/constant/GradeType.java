package com.github.imjoony83.jpagradle.constant;

import lombok.Getter;

public enum  GradeType {
    LEVEL_1("LEVEL_1"),
    LEVEL_2("LEVEL_2");

    @Getter
    private String gradeAlias;

    GradeType(String gradeAlias) {
        this.gradeAlias = gradeAlias;
    }
}
