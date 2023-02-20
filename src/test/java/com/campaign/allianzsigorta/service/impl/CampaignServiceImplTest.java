package com.campaign.allianzsigorta.service.impl;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import com.campaign.allianzsigorta.model.dto.CampaignDTO;
import com.campaign.allianzsigorta.model.entity.CampaignEntity;
import com.campaign.allianzsigorta.repository.CampaignRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CampaignServiceImplTest {

    @InjectMocks
    CampaignServiceImpl service;

    @Mock
    CampaignRepository repository;

    @Mock
    ModelMapper mapper;

    CampaignEntity request;

    CampaignEntity response;


    CampaignDTO dto;


    @BeforeEach
    void setUp() {
        request=new CampaignEntity();
        response=new CampaignEntity();
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        dto = new CampaignDTO();
        CampaignDTO responseDTO = new CampaignDTO();
        responseDTO.setStatus(StatusEnum.AKTIF);
        dto.setCampaignCategory(CampaignCategoryEnum.OSS);
        response.setStatus(StatusEnum.AKTIF);
        Mockito.when(repository.save(request)).thenReturn(response);
        Mockito.when(mapper.map(dto,CampaignEntity.class)).thenReturn(request);
        Mockito.when(mapper.map(response, CampaignDTO.class)).thenReturn(responseDTO);
        CampaignDTO response = service.save(dto);

        assertNotNull(response);
    }

    @Test
    void confirmation() {
    }

    @Test
    void reject() {
    }
}