package com.campaign.allianzsigorta.repository;

import com.campaign.allianzsigorta.model.dto.CampaignResponseDTO;
import com.campaign.allianzsigorta.model.entity.QCampaignEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampaignCustomRepositoryImpl extends QuerydslRepositorySupport implements CampaignCustomRepository {

    public CampaignCustomRepositoryImpl() {
        super(QCampaignEntity.class);
    }

    @Override
    public List<CampaignResponseDTO> getList() {
        QCampaignEntity qCampaignEntity = QCampaignEntity.campaignEntity;

        JPQLQuery<CampaignResponseDTO> query = from(qCampaignEntity).select(
                Projections.bean(CampaignResponseDTO.class,
                        qCampaignEntity.status.count().intValue().as("total"),
                        qCampaignEntity.status
                )
        ).groupBy(qCampaignEntity.status);
        return query.fetch();
    }
}
