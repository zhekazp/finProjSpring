package org.blb.controller.news;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.service.news.DeleteNewsDataService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class DeleteNewsController {
    private final DeleteNewsDataService deleteNewsDataService;

    @DeleteMapping("/delete/{newsId}")
    public StandardResponseDto deleteNewsById(@PathVariable Long newsId) {
        return deleteNewsDataService.deleteNewsDataById(newsId);
    }
}
