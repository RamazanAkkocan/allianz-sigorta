package com.campaign.allianzsigorta.model.dto;

import com.campaign.allianzsigorta.enumerated.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignResponseDTO {

    private StatusEnum status;

    private Integer total;
}
