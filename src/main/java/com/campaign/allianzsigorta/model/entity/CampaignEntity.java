package com.campaign.allianzsigorta.model.entity;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import com.campaign.allianzsigorta.constant.GeneralConstant;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class CampaignEntity extends BaseEntity {

    @NotNull
    @Column(name = "advert_title")
    @Size(min = GeneralConstant.MIN_TITLE_SIZE, max = GeneralConstant.MAX_TITLE_SIZE)
    private String advertTitle;

    @NotNull
    @Column(name = "detail_description")
    @Size(min = GeneralConstant.MIN_DESCRIPTON_SIZE, max = GeneralConstant.MAX_DESCRIPTON_SIZE)
    private String detailDescription;

    @NotNull
    @Column(name = "campaign_category")
    private CampaignCategoryEnum campaignCategory;

    @NotNull
    @Column(name = "status")
    private StatusEnum status;

}
