package com.campaign.allianzsigorta.enumerated;

import lombok.Getter;

import java.util.Arrays;


/**
 * @author r.akkocan
 */

@Getter
public enum CampaignCategoryEnum {

    TSS("Tamamlayıcı Sağlık Sigortası", 0),

    OSS("Özel Sağlık Sigortası", 1),

    HY("Hayat Sigortası", 2),

    DIGER("Diğer", 3);

    private String label;

    private final Integer value;

    CampaignCategoryEnum(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public static CampaignCategoryEnum getEnumByValue(Integer value) {
        return Arrays.stream(CampaignCategoryEnum.values()).filter(f -> f.getValue().equals(value)).findFirst().orElse(null);
    }

}
