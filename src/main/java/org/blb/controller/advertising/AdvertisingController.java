package org.blb.controller.advertising;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.advertisingDto.AdvertisingRequestDto;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.blb.DTO.advertisingDto.ShortAdvertisingResponseDto;
import org.blb.DTO.appDTO.StandardDelRequest;
import org.blb.DTO.appDTO.StandardResponseDto;
//import org.blb.controller.api.advertising.AdvertisingApi;
import org.blb.repository.advertising.AdvertisingRepository;
import org.blb.service.advertising.CreateAdvertisingService;
import org.blb.service.advertising.DeleteAdvertisingService;
import org.blb.service.advertising.FindAdvertisingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
//@RequiredArgsConstructor
//public class AdvertisingController  {
//    private final CreateAdvertisingService createAdvertisingService;
//    private final DeleteAdvertisingService deleteAdvertisingService;
//    private final FindAdvertisingService findAdvertisingService;
//    private final AdvertisingRepository advertisingRepository;
//
//    public ResponseEntity<ShortAdvertisingResponseDto> addAdvertising(AdvertisingRequestDto dto) {
//        createAdvertisingService.addAdvertising(dto);
//        return ResponseEntity.ok(new ShortAdvertisingResponseDto());
//    }
//
//
//    public ResponseEntity<StandardResponseDto> deleteAdvertising(StandardDelRequest dto) {
//        deleteAdvertisingService.deleteAdvertising(dto.getId());
//        return ResponseEntity.ok(new StandardResponseDto("Advertising removed successfully"));
//    }
//
//
//    public ResponseEntity<StandardResponseDto> updateAdvertising(AdvertisingRequestDto dto) {
//        return null;
//    }
//
//
//
//    public ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(String email) {
//        AdvertisingResponseDto responseDto = findAdvertisingService.findByAdvertiserEmail(email);
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @Override
//    public ResponseEntity<List<ShortAdvertisingResponseDto>> findAll() {
//        List<ShortAdvertisingResponseDto> responseDto = findAdvertisingService.findAll();
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @Override
//    public ResponseEntity<ShortAdvertisingResponseDto> findAdvertisingById(Long id) {
//        ShortAdvertisingResponseDto response = findAdvertisingService.findAdvertisingById(id);
//        return ResponseEntity.ok(response);
//
//    }
//
//    @Override
//    public ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings() {
//        List<ShortAdvertisingResponseDto> response = findAdvertisingService.findFiveRandomAdvertisings();
//        return ResponseEntity.ok(response);
//    }
//}




@RestController
@RequestMapping("/advertising")
@RequiredArgsConstructor
public class AdvertisingController {

    private final CreateAdvertisingService createAdvertisingService;
    private final DeleteAdvertisingService deleteAdvertisingService;
    private final FindAdvertisingService findAdvertisingService;

    @PutMapping
    public ResponseEntity<AdvertisingResponseDto> addAdvertising(@RequestBody AdvertisingRequestDto requestDto) {
        AdvertisingResponseDto responseDto = createAdvertisingService.addAdvertising(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertising(@PathVariable Long id) {
        deleteAdvertisingService.deleteAdvertising(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email")
    public ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(@RequestParam String email) {
        AdvertisingResponseDto responseDto = findAdvertisingService.findByAdvertiserEmail(email);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ShortAdvertisingResponseDto>> findAll() {
        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findAll();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShortAdvertisingResponseDto> findAdvertisingById(@PathVariable Long id) {
        ShortAdvertisingResponseDto responseDto = findAdvertisingService.findAdvertisingById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/random")
    public ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings() {
        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findFiveRandomAdvertisings();
        return ResponseEntity.ok(responseDtos);
    }
}