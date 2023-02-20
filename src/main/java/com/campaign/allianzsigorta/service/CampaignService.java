package com.campaign.allianzsigorta.service;

import com.campaign.allianzsigorta.model.dto.CampaignDTO;
import com.campaign.allianzsigorta.model.dto.CampaignResponseDTO;

import java.util.List;

public interface CampaignService {

    CampaignDTO findById (Long id);

    CampaignDTO save (CampaignDTO dto);

    CampaignDTO confirmation(Long id);

    CampaignDTO reject(Long id);

    List<CampaignResponseDTO> getStatistics ();
}
