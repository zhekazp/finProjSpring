package org.blb.controller.api;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.blb.DTO.appDTO.ResponseErrors;
import org.blb.DTO.blog.blogs.BlogsResponseDTO;
import org.blb.DTO.blog.blogs.ContentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/blogs")
@CrossOrigin(origins = "http://localhost:5173")
public interface BlogsApi {
    @Operation(summary = "Getting last blogs", description = "The operation is available to everyone, return 10 blogs from latest")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description ="return total page count, current page, and 10 blogs if available.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BlogsResponseDTO.class)))

    })

    @GetMapping()
    public ResponseEntity<BlogsResponseDTO> getBlogs(@RequestParam Integer page, @RequestParam Long region);
    @GetMapping("/{id}")
    public ResponseEntity<ContentResponseDTO> getBlog(@PathVariable Long id);
}
