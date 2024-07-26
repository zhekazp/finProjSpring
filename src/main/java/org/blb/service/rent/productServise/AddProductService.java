package org.blb.service.rent.productServise;

import lombok.AllArgsConstructor;
import org.blb.DTO.appDTO.OneMessageDTO;
import org.blb.DTO.rent.productDto.ProductCreateRequestDto;
import org.blb.DTO.validationErrorDto.ValidationErrorDto;
import org.blb.DTO.validationErrorDto.ValidationErrorsDto;
import org.blb.exeption.NotFoundException;
import org.blb.models.region.Region;
import org.blb.models.rent.Product;
import org.blb.models.user.User;
import org.blb.repository.UserRepository;
import org.blb.repository.region.RegionRepository;
import org.blb.repository.rent.CategoryRepository;
import org.blb.repository.rent.ProductRepository;
import org.blb.service.util.rentMapping.ProductConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductConverter productConverter;
    private final UserRepository userRepository;
    private final RegionRepository regionRepository;

    public ResponseEntity<?> addProduct(ProductCreateRequestDto requestDto) {
        List<ValidationErrorDto> errors = new ArrayList<>();

        if (requestDto.getUser() == null) {
            errors.add(new ValidationErrorDto("user", "User not found"));
        } else {
            userRepository.findById(requestDto.getUser()).orElse(null);
            if (!userRepository.existsById(requestDto.getUser())) {
                errors.add(new ValidationErrorDto("user", "User with id " + requestDto.getUser() + " not found."));
            }
        }

        if (requestDto.getRegion() == null || requestDto.getRegion().getRegionName() == null) {
            errors.add(new ValidationErrorDto("region", "Region not found"));
        } else {
            if (!regionRepository.findByRegionName(requestDto.getRegion().getRegionName()).isPresent()) {
                errors.add(new ValidationErrorDto("region", "Region with name " + requestDto.getRegion().getRegionName() + " not found."));
            }
        }

        if (requestDto.getCategory() == null) {
            errors.add(new ValidationErrorDto("category", "Category not found"));
        } else {
            if (!categoryRepository.findByName(requestDto.getCategory().getName()).isPresent()) {
                errors.add(new ValidationErrorDto("category", "Category with name " + requestDto.getCategory().getName() + " not found."));
            }
        }

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(new ValidationErrorsDto(errors), HttpStatus.BAD_REQUEST);
        }

        try {

            Product productForAdd = productConverter.fromDto(requestDto);

            productForAdd.setIsInStock(requestDto.getIsInStock() != null ? requestDto.getIsInStock() : true);

            if (requestDto.getUser() != null) {
                User user = userRepository.findById(requestDto.getUser()).orElseThrow();
                productForAdd.setUser(user);
            }

            if (requestDto.getRegion() != null) {
                Region region = regionRepository.findByRegionName(requestDto.getRegion().getRegionName()).orElseThrow();
                productForAdd.setRegion(region);
            }

            productForAdd.setDescription(requestDto.getDescription());

            productRepository.save(productForAdd);

            return new ResponseEntity<>(new OneMessageDTO("Product successfully created"), HttpStatus.CREATED);

        } catch (NotFoundException e) {
            return new ResponseEntity<>(new OneMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new OneMessageDTO("An unexpected error occurred. Please try again later."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
