package com.campaign.allianzsigorta.repository;


import com.campaign.allianzsigorta.model.dto.CampaignResponseDTO;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoRepositoryBean
public interface CampaignCustomRepository {

    List<CampaignResponseDTO> getList();
}
