package com.campaign.allianzsigorta.model.dto;

import com.campaign.allianzsigorta.constant.GeneralConstant;
import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class CampaignDTO extends BaseDTO {

    @Size(min = GeneralConstant.MIN_TITLE_SIZE, max = GeneralConstant.MAX_TITLE_SIZE)
    private String advertTitle;

    @Size(min = GeneralConstant.MIN_DESCRIPTON_SIZE, max = GeneralConstant.MAX_DESCRIPTON_SIZE)
    private String detailDescription;

    private CampaignCategoryEnum campaignCategory;

    private StatusEnum status;
}
