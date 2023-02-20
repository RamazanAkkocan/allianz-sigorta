package com.campaign.allianzsigorta.repository;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.model.entity.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {

    boolean existsByCampaignCategoryAndAdvertTitleAndDetailDescription(CampaignCategoryEnum campaignCategory, String advertTitle, String detailDescription);
}
