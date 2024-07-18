package org.blb.DTO.blog;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogRequestRemoveDTO {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    @Min(1)
    private Integer UserId;
}
