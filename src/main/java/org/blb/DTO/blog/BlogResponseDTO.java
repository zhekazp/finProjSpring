package org.blb.DTO.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogResponseDTO {
    private int id;
    private String title;
    private String content;

}
