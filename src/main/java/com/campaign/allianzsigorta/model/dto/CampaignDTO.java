package com.campaign.allianzsigorta.model.dto;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignDTO extends BaseDTO {

    private String advertTitle;

    private String detailDescription;

    private CampaignCategoryEnum campaignCategory;

    private StatusEnum status;
}
