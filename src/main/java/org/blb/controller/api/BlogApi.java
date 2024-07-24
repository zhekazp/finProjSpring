package org.blb.controller.api;

import jakarta.validation.Valid;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.DTO.blog.BlogAddRequestDTO;
import org.blb.DTO.blog.blogs.BlogResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:5173")
public interface BlogApi {
    @PutMapping()
    public ResponseEntity<StandardResponseDto> addBlog(@RequestBody @Valid BlogAddRequestDTO dto);

}
