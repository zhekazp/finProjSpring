package org.blb.controller.blog;


import lombok.RequiredArgsConstructor;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.DTO.blog.BlogAddRequestDTO;
import org.blb.controller.api.BlogApi;
import org.blb.service.blog.BlogDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogController implements BlogApi {
    private final BlogDataService blogDataService;

    @Override
    public ResponseEntity<StandardResponseDto> addBlog(BlogAddRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(blogDataService.addBlog(dto));
    }
}
