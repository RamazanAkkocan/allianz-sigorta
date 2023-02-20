package com.campaign.allianzsigorta.controller;

import com.campaign.allianzsigorta.model.dto.CampaignDTO;
import com.campaign.allianzsigorta.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ramazan akkocan
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class CampaignController {

    private final CampaignService service;

    @GetMapping("/campany/{id}")
    public ResponseEntity<CampaignDTO> findByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/campany/save")
    public ResponseEntity<CampaignDTO> save(@RequestBody CampaignDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/campany/confirmation/{id}")
    public ResponseEntity<CampaignDTO> confirmation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.confirmation(id));
    }

    @PutMapping("/campany/reject/{id}")
    public ResponseEntity<CampaignDTO> reject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.reject(id));
    }

}
