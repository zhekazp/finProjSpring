package org.blb.DTO.blog.blogs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BlogsResponseDTO {
    private Integer pageCount;
    private Integer currentPage;
    private List<BlogResponseDTO> blogs;
}
