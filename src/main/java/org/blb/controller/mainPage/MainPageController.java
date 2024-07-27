package org.blb.controller.mainPage;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.mainPageDto.MpResponseDTO;
import org.blb.DTO.mainPageDto.MpWeatherDTO;
import org.blb.controller.api.mainPage.MainPageAPi;
import org.blb.service.mainPage.MainPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainPageController implements MainPageAPi {
    private final MainPageService mainPageService;
    @Override
    public ResponseEntity<MpResponseDTO> getMainPage() {
        return ResponseEntity.ok(mainPageService.getData());
    }

    @Override
    public ResponseEntity<MpWeatherDTO> weather() {
        return ResponseEntity.ok(mainPageService.getWeather());
    }
}
