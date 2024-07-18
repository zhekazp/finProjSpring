package org.blb.controller;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {
    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<BlogResponseDTO> test(){
        return ResponseEntity.ok(new BlogResponseDTO(1,"test","teat"));
    }
}
