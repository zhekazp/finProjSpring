package org.blb.controller.blog;


import lombok.RequiredArgsConstructor;
import org.blb.DTO.appDTO.StandardDelRequest;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.DTO.blog.BlogAddRequestDTO;
import org.blb.DTO.blog.BlogUpdateDTO;
import org.blb.controller.api.blog.BlogApi;
import org.blb.service.blog.BlogDataService;
import org.blb.service.blog.BlogFindService;
import org.blb.service.blog.BlogUpdateService;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogController implements BlogApi {
    private final BlogDataService blogDataService;
    private final BlogFindService blogFindService;
    private final BlogUpdateService blogUpdateService;
    private final DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

    @Override
    public ResponseEntity<StandardResponseDto> addBlog(BlogAddRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(blogDataService.addBlog(dto));
    }

    @Override
    public ResponseEntity<StandardResponseDto> delBlog(StandardDelRequest dto) {
         blogUpdateService.remove(dto);
        return ResponseEntity.ok(new StandardResponseDto("Blog removed success"));
    }

    @Override
    public ResponseEntity<StandardResponseDto> updateBlog(BlogUpdateDTO dto) {
        blogUpdateService.update(dto);
        return ResponseEntity.ok(new StandardResponseDto("Blog updated success"));
    }


}
