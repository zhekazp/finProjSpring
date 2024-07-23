package org.blb.DTO.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogsRequestDTO {
    Long pageNumber;
    Long region_ID;
}
