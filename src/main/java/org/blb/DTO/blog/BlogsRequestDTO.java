package org.blb.DTO.blog;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request for blogs list")
public class BlogsRequestDTO {
    @Schema(description = "Index of current page", example = "0")
    Integer pageNumber;
    @Schema(description = "Region id", example = "7")
    Long region_ID;
}
