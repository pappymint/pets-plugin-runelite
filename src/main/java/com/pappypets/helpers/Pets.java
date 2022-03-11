package com.pappypets.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Pets {
    WHITE_CAT("Pet cat", 1562),
    ROCKY("Rocky", 20663);

    private final String name;
    private final int petID;

    public String getPetName() {
        return name;
    }
}