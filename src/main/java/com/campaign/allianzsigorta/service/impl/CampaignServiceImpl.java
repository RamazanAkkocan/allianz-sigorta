package com.campaign.allianzsigorta.service.impl;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import com.campaign.allianzsigorta.exception.NoDataFoundException;
import com.campaign.allianzsigorta.model.dto.CampaignDTO;
import com.campaign.allianzsigorta.model.dto.CampaignResponseDTO;
import com.campaign.allianzsigorta.model.entity.CampaignEntity;
import com.campaign.allianzsigorta.repository.CampaignCustomRepository;
import com.campaign.allianzsigorta.repository.CampaignRepository;
import com.campaign.allianzsigorta.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author r.akkocan
 */

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository repository;

    private final ModelMapper mapper;

    private final CampaignCustomRepository customRepository;

    /**
     * Id'ye göre Kampaynya Bilgisini Döndürür.
     *
     * @param id Long
     * @return CampanyDTO
     */
    @Override
    @Transactional(readOnly = true)
    public CampaignDTO findById(Long id) {
        CampaignEntity entity = repository.findById(id).orElseThrow(() -> new NoDataFoundException("Kayıt Bulunamadı"));
        return mapper.map(entity, CampaignDTO.class);
    }

    /**
     * Kampanya Bilgisini Kayıt eder.
     *
     * @param dto CampanyDTO
     * @return CampanyDTO
     */
    @Override
    @Transactional
    public CampaignDTO save(CampaignDTO dto) {

        if (dto.getCampaignCategory().equals(CampaignCategoryEnum.HY)) {
            dto.setStatus(StatusEnum.AKTIF);
        } else {
            dto.setStatus(StatusEnum.BEKLEMEDE);
        }
        boolean hasSameCamping = repository.existsByCampaignCategoryAndAdvertTitleAndDetailDescription(dto.getCampaignCategory(), dto.getAdvertTitle(), dto.getDetailDescription());
        if (hasSameCamping) {
            dto.setStatus(StatusEnum.MUKERRER);
        }
        CampaignEntity entity = repository.save(mapper.map(dto, CampaignEntity.class));
        return mapper.map(entity, CampaignDTO.class);
    }

    /**
     * İlgili Kaydın Onaylanma İşlemini Yapar.
     *
     * @param id Long Onaylanacak Kaydın Primary Keyi
     * @return CampaignDTO
     */
    @Override
    @Transactional
    public CampaignDTO confirmation(Long id) {
        CampaignEntity entity = repository.findById(id).orElseThrow(() -> new NoDataFoundException("Kayıt Bulunamadı"));
        if (!entity.getStatus().equals(StatusEnum.BEKLEMEDE)) {
            throw new NoDataFoundException("Bu Kaydın Statusu " + entity.getStatus().getLabel() + " Olduğundan Onaylanamaz!");
        }

        entity.setStatus(StatusEnum.AKTIF);

        return mapper.map(repository.save(entity), CampaignDTO.class);
    }

    /**
     * İlgili Kaydın Reddetme İşlemini Yapar.
     *
     * @param id Long Onaylanacak Kaydın Primary Keyi
     * @return CampaignDTO
     */
    @Override
    @Transactional
    public CampaignDTO reject(Long id) {
        CampaignEntity entity = repository.findById(id).orElseThrow(() -> new NoDataFoundException("Kayıt Bulunamadı"));
        if (!entity.getStatus().equals(StatusEnum.AKTIF) && !entity.getStatus().equals(StatusEnum.BEKLEMEDE)) {
            throw new NoDataFoundException("Bu Kaydın Statusu " + entity.getStatus().getLabel() + " Olduğundan Reddedilemez!");
        }

        entity.setStatus(StatusEnum.DEAKTIF);

        return mapper.map(repository.save(entity), CampaignDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CampaignResponseDTO> getStatistics() {
        return customRepository.getList();
    }
}
