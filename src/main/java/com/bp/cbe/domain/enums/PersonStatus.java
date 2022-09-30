package com.bp.cbe.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonStatus {
    CREATED("CREADO"),
    ACTIVE("ACTIVO"),
    INACTIVE("INACTIVO");

    private final String spanishText;

    @Override
    public String toString() {
        return spanishText;
    }

}
