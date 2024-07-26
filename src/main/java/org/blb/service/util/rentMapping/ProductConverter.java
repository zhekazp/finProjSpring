package org.blb.service.util.rentMapping;


import lombok.AllArgsConstructor;
import org.blb.DTO.region.RegionDTO;
import org.blb.DTO.rent.categoryDto.CategoryCreateRequestDto;
import org.blb.DTO.rent.productDto.ProductCreateRequestDto;
import org.blb.DTO.rent.productDto.ProductResponseDto;
import org.blb.models.region.Region;
import org.blb.models.rent.Category;
import org.blb.models.rent.Product;
import org.blb.models.user.User;
import org.blb.repository.UserRepository;
import org.blb.repository.region.RegionRepository;
import org.blb.repository.rent.CategoryRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductConverter {

    private final UserRepository userRepository;
    public final CategoryRepository categoryRepository;
    public final RegionRepository regionRepository;


    public Product fromDto(ProductCreateRequestDto dto){
        Product product = new Product();

        if(dto.getName() != null){
            product.setName(dto.getName());
        }

        if (dto.getCategory() != null) {
            Optional<Category> categoryOpt = categoryRepository.findByName(dto.getCategory().getName());
            categoryOpt.ifPresent(product::setCategory);
        }

        if(dto.getPrice() != null){
            product.setPrice(dto.getPrice());
        }

        if(dto.getIsInStock() != null){
            product.setIsInStock(dto.getIsInStock());
        }

        if(dto.getDescription() != null){
            product.setDescription(dto.getDescription());
        }

        if (dto.getRegion() != null) {
            Optional<Region> regionOpt = regionRepository.findByRegionName(dto.getRegion().getRegionName());
            regionOpt.ifPresent(product::setRegion);
        }

        if (dto.getUser() != null) {
            Optional<User> userOpt = userRepository.findById(dto.getUser());
            userOpt.ifPresent(product::setUser);
        }

        return product;
    }

    public ProductResponseDto toDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();

        if(product.getName() != null){
            productResponseDto.setName(product.getName());
        }
        if (product.getCategory() != null) {
            CategoryCreateRequestDto categoryDTO = new CategoryCreateRequestDto(product.getCategory().getName());
            productResponseDto.setCategory(categoryDTO);
        }
        if(product.getPrice() != null){
            productResponseDto.setPrice(product.getPrice());
        }
        if(product.getIsInStock() != null){
            productResponseDto.setIsInStock(product.getIsInStock());
        }

        if(product.getDescription() != null){
            productResponseDto.setDescription(product.getDescription());
        }

        if (product.getRegion() != null) {
            RegionDTO regionDtowithoutId = new RegionDTO(product.getRegion().getRegionName());
            productResponseDto.setRegion(regionDtowithoutId);
        }

        return productResponseDto;
    }
}
