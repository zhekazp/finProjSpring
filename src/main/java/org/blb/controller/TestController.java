package org.blb.controller;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogsRequestDTO;

import org.blb.DTO.blog.blogs.BlogsResponseDTO;

import org.blb.repository.blog.BlogFindRepository;
import org.blb.repository.blog.BlogRepository;
import org.blb.service.blog.BlogFindService;
import org.blb.service.region.FindRegionService;
import org.blb.service.user.UserFindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class TestController {
    private final UserFindService userFindService;
    private final BlogRepository blogRepository;
    private final FindRegionService findRegionService;
    private final BlogFindRepository blogFindRepository;
    private final BlogFindService blogFindService;

    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<BlogsResponseDTO> test(){


        return ResponseEntity.ok(blogFindService.findAll(new BlogsRequestDTO(0,(long)7)));
    }
}
