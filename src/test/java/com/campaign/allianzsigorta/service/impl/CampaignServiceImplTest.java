package com.campaign.allianzsigorta.service.impl;

import com.campaign.allianzsigorta.enumerated.CampaignCategoryEnum;
import com.campaign.allianzsigorta.enumerated.StatusEnum;
import com.campaign.allianzsigorta.model.dto.CampaignDTO;
import com.campaign.allianzsigorta.model.dto.CampaignResponseDTO;
import com.campaign.allianzsigorta.model.entity.CampaignEntity;
import com.campaign.allianzsigorta.repository.CampaignCustomRepositoryImpl;
import com.campaign.allianzsigorta.repository.CampaignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CampaignServiceImplTest {

    @InjectMocks
    CampaignServiceImpl service;

    @Mock
    CampaignRepository repository;

    @Mock
    CampaignCustomRepositoryImpl customRepository;

    @Mock
    ModelMapper mapper;

    CampaignEntity request;

    CampaignEntity response;

    CampaignDTO dto;

    @BeforeEach
    void setUp() {
        request = new CampaignEntity();
        response = new CampaignEntity();
    }

    @Test
    void findById() {
        CampaignDTO responseDTO = new CampaignDTO();
        response.setStatus(StatusEnum.AKTIF);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(response));
        Mockito.when(mapper.map(response, CampaignDTO.class)).thenReturn(responseDTO);

        CampaignDTO response = service.findById(1L);
        assertNotNull(response);
    }

    @Test
    void save() {
        dto = new CampaignDTO();
        CampaignDTO responseDTO = new CampaignDTO();
        responseDTO.setStatus(StatusEnum.AKTIF);
        dto.setCampaignCategory(CampaignCategoryEnum.OSS);
        response.setStatus(StatusEnum.AKTIF);
        Mockito.when(repository.save(request)).thenReturn(response);
        Mockito.when(mapper.map(dto, CampaignEntity.class)).thenReturn(request);
        Mockito.when(mapper.map(response, CampaignDTO.class)).thenReturn(responseDTO);

        CampaignDTO response = service.save(dto);
        assertNotNull(response);
    }

    @Test
    void confirmation() {
        dto = new CampaignDTO();
        CampaignDTO responseDTO = new CampaignDTO();
        responseDTO.setStatus(StatusEnum.AKTIF);
        dto.setCampaignCategory(CampaignCategoryEnum.OSS);
        response.setStatus(StatusEnum.BEKLEMEDE);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(response));
        Mockito.when(repository.save(response)).thenReturn(response);
        Mockito.when(mapper.map(response, CampaignDTO.class)).thenReturn(responseDTO);

        CampaignDTO response = service.confirmation(1L);
        assertNotNull(response);
    }

    @Test
    void reject() {

        dto = new CampaignDTO();
        CampaignDTO responseDTO = new CampaignDTO();
        responseDTO.setStatus(StatusEnum.BEKLEMEDE);
        dto.setCampaignCategory(CampaignCategoryEnum.OSS);
        response.setStatus(StatusEnum.BEKLEMEDE);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(response));
        Mockito.when(repository.save(response)).thenReturn(response);
        Mockito.when(mapper.map(response, CampaignDTO.class)).thenReturn(responseDTO);

        CampaignDTO response = service.reject(1L);
        assertNotNull(response);
    }

    @Test
    void getStatistics() {
        CampaignResponseDTO dto = new CampaignResponseDTO();
        dto.setStatus(StatusEnum.AKTIF);
        dto.setTotal(2);
        List<CampaignResponseDTO> responseList = new ArrayList<>();
        responseList.add(dto);
        Mockito.when(customRepository.getList()).thenReturn(responseList);

        responseList = service.getStatistics();
        assertNotNull(responseList);
    }

}