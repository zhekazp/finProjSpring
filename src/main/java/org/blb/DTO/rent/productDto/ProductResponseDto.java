package org.blb.DTO.rent.productDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blb.DTO.region.RegionDTO;
import org.blb.DTO.rent.categoryDto.CategoryCreateRequestDto;
import org.blb.DTO.user.UserJustWithNameDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String name;
    private CategoryCreateRequestDto category;
    private Double price;
    private String description;
    private RegionDTO region;
    private Boolean isInStock;
    private UserJustWithNameDto owner;

}
