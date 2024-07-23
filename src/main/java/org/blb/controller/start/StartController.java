package org.blb.controller.start;

import lombok.AllArgsConstructor;
import org.blb.service.startTest.StartTestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StartController {
    private final StartTestRepository startTestRepository;

    @GetMapping("/start")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> test(){
        startTestRepository.startBlog();
        return ResponseEntity.ok("ok");
    }

}
