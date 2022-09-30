package com.bp.cbe.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {
    INVITED("INVITADO"),
    INTERN("INTERNO"),
    EXTERN("EXTERNO");

    private final String spanishText;

    @Override
    public String toString() {
        return spanishText;
    }
}
