package org.blb.controller.api;

import jakarta.validation.Valid;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.DTO.blog.BlogAddRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/blog")
@CrossOrigin(origins = "http://localhost:5173")
public interface BlogApi {
    @PostMapping("")
    public ResponseEntity<StandardResponseDto> addBlog(@RequestBody @Valid BlogAddRequestDTO dto);
}
