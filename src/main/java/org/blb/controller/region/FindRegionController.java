package org.blb.controller.region;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.blb.DTO.region.RegionDTO;
import org.blb.service.region.FindRegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class FindRegionController {
    private final FindRegionService service;

    @GetMapping
    public ResponseEntity<List<RegionDTO>> findAllRegions() {
        ResponseEntity<List<RegionDTO>> response = service.findAllRegions();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/findById")
    public ResponseEntity<RegionDTO> findRegionById(@Valid @RequestParam Long id) {
        return new ResponseEntity<>(service.findRegionById(id), HttpStatus.OK);
    }

    @GetMapping("/findBy")
    public ResponseEntity<RegionDTO> findRegionByName(@Valid @RequestParam String region) {
        return new ResponseEntity<>(service.findRegionByName(region), HttpStatus.OK);
    }
}
