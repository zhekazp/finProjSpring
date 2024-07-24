package org.blb.controller.news;

import lombok.AllArgsConstructor;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.service.news.AddNewsDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class AddNewsController {
    private final AddNewsDataService addNewsDataService;

    @PostMapping("/loading")
    public StandardResponseDto loadAllNewsFromAPIsToDataBase(){
        return addNewsDataService.saveNewsFromFetchApi();
    }
}
