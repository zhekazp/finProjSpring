package org.blb.controller.api;


import org.blb.DTO.blog.blogs.BlogsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/blogs")
@CrossOrigin(origins = "http://localhost:5173")
public interface BlogsApi {
    @GetMapping()
    public ResponseEntity<BlogsResponseDTO> getBlogs(@RequestParam Integer page, @RequestParam Long region);
}
