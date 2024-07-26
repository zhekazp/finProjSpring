package org.blb.DTO.blog.blogs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContentResponseDTO {
    @Schema(description = "content of a blog", example = "some content")
    private String content;

    List<BlogCommentResponseDTO> comments;
}
