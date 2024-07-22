package org.blb.controller;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogResponseDTO;
import org.blb.service.user.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {
    UserAuthService userAuthService;
    @GetMapping("/test/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> test( @PathVariable String id){
       return ResponseEntity.ok("ok");
    }
}
