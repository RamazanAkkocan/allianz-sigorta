package com.campaign.allianzsigorta.enumerated;

import lombok.Getter;

import java.util.Arrays;


/**
 * @author r.akkocan
 */

@Getter
public enum StatusEnum {

    DEAKTIF("Deaktif", 0),

    AKTIF("Aktif", 1),

    BEKLEMEDE("Onay Bekliyor", 2),

    MUKERRER("Mükerrer", 3);

    private String label;

    private final Integer value;

    StatusEnum(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public static StatusEnum getEnumByValue(Integer value) {
        return Arrays.stream(StatusEnum.values()).filter(f -> f.getValue().equals(value)).findFirst().orElse(null);
    }
}
