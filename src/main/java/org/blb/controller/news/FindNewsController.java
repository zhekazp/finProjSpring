package org.blb.controller.news;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.news.NewsDataResponseDto;
import org.blb.service.news.FindNewsDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class FindNewsController {

    private final FindNewsDataService findNewsDataService;

    @GetMapping
    public ResponseEntity<List<NewsDataResponseDto>> findAllNews() {
        ResponseEntity<List<NewsDataResponseDto>> response = findNewsDataService.findAllNews();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/{newsId}")
    public ResponseEntity<NewsDataResponseDto> findNewsById(@PathVariable Long newsId) {
        ResponseEntity<NewsDataResponseDto> response = findNewsDataService.findNewsById(newsId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<NewsDataResponseDto>> findByCriteria(@RequestParam String section, @RequestParam String region) {
        ResponseEntity<List<NewsDataResponseDto>> response = findNewsDataService.findAllNewsByCriteria(section, region);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/region/id/{regionId}")
    public ResponseEntity<List<NewsDataResponseDto>> findAllNewsByRegionId(@PathVariable Long regionId){
        ResponseEntity<List<NewsDataResponseDto>> response = findNewsDataService.findAllNewsByRegionId(regionId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}