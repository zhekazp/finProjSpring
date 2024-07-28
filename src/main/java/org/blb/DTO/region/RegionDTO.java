package org.blb.DTO.region;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Region DTO")
public class RegionDTO {

    @NotBlank(message = "Region name must be not blank.")
    @NotNull(message = "Region name must be not null.")
    @Schema(description = "Region name", example = "Hessen")
    private String regionName;

}
