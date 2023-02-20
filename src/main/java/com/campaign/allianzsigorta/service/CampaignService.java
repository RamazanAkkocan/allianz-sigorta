package com.campaign.allianzsigorta.service;

import com.campaign.allianzsigorta.model.dto.CampaignDTO;

public interface CampaignService {

    CampaignDTO findById (Long id);

    CampaignDTO save (CampaignDTO dto);

    CampaignDTO confirmation(Long id);

    CampaignDTO reject(Long id);
}
