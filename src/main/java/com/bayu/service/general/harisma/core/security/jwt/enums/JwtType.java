package com.bayu.service.general.harisma.core.security.jwt.enums;

public enum JwtType {
    ACCESS, REFRESH;

    public String getCodeName() {
        return toString().toLowerCase();
    }
}
