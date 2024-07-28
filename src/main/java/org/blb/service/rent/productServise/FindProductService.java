package org.blb.service.rent.productServise;

import lombok.AllArgsConstructor;
import org.blb.DTO.errorDto.ErrorResponseDto;
import org.blb.DTO.errorDto.FieldErrorDto;
import org.blb.DTO.rent.ProductSearchResponse;
import org.blb.DTO.rent.productDto.ProductResponseDto;
import org.blb.exeption.NotFoundException;
import org.blb.models.region.Region;
import org.blb.models.rent.Category;
import org.blb.models.rent.Product;
import org.blb.repository.region.RegionRepository;
import org.blb.repository.rent.CategoryRepository;
import org.blb.repository.rent.ProductRepository;
import org.blb.service.util.rentMapping.ProductConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryRepository categoryRepository;
    private final RegionRepository regionRepository;

    public ProductSearchResponse findProducts(String regionName, String categoryName, String name) {
        List<FieldErrorDto> fieldErrors = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        Optional<Region> regionOpt = regionName != null ? regionRepository.findByRegionName(regionName) : Optional.empty();
        Optional<Category> categoryOpt = categoryName != null ? categoryRepository.findByName(categoryName) : Optional.empty();

        if (regionName != null && categoryName != null && name != null) {
            products = findByRegionAndCategoryAndName(regionOpt, categoryOpt, name, fieldErrors);
        } else if (regionName != null && categoryName != null) {
            products = findByRegionAndCategory(regionOpt, categoryOpt, fieldErrors);
        } else if (regionName != null && name != null) {
            products = findByRegionAndName(regionOpt, name, fieldErrors);
        } else if (categoryName != null && name != null) {
            products = findByCategoryAndName(categoryOpt, name, fieldErrors);
        } else if (regionName != null) {
            products = findByRegion(regionOpt, fieldErrors);
        } else if (categoryName != null) {
            products = findByCategory(categoryOpt, fieldErrors);
        } else if (name != null) {
            products = findByName(name, fieldErrors);
        } else {
            products = productRepository.findAll();
        }

        if (products.isEmpty() && fieldErrors.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("criteria", "No products found for the specified criteria", null));
        }

        List<ProductResponseDto> dtos = products.stream()
                .map(productConverter::toDto)
                .collect(Collectors.toList());

        return new ProductSearchResponse(dtos, fieldErrors.isEmpty() ? null : new ErrorResponseDto("Errors occurred", fieldErrors));
    }


    private List<Product> findByRegionAndCategoryAndName(Optional<Region> regionOpt, Optional<Category> categoryOpt, String name, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (regionOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("region", "Region not found", null));
        }
        if (categoryOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("category", "Category not found", null));
        }
        if (regionOpt.isPresent() && categoryOpt.isPresent()) {
            products = productRepository.findAllByRegionAndCategoryAndNameStartingWithIgnoreCase(regionOpt.get(), categoryOpt.get(), name);
        }
        return products;
    }

    private List<Product> findByRegionAndCategory(Optional<Region> regionOpt, Optional<Category> categoryOpt, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (regionOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("region", "Region not found", null));
        }
        if (categoryOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("category", "Category not found", null));
        }
        if (regionOpt.isPresent() && categoryOpt.isPresent()) {
            products = productRepository.findAllByRegionAndCategory(regionOpt.get(), categoryOpt.get());
        }
        return products;
    }

    private List<Product> findByRegionAndName(Optional<Region> regionOpt, String name, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (regionOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("region", "Region not found", null));
        } else {
            products = productRepository.findAllByRegionAndNameStartingWithIgnoreCase(regionOpt.get(), name);
        }
        return products;
    }

    private List<Product> findByCategoryAndName(Optional<Category> categoryOpt, String name, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (categoryOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("category", "Category not found", null));
        } else {
            products = productRepository.findAllByCategoryAndNameStartingWithIgnoreCase(categoryOpt.get(), name);
        }
        return products;
    }

    private List<Product> findByRegion(Optional<Region> regionOpt, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (regionOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("region", "Region not found", null));
        } else {
            products = productRepository.findAllByRegion(regionOpt.get());
        }
        return products;
    }

    private List<Product> findByCategory(Optional<Category> categoryOpt, List<FieldErrorDto> fieldErrors) {
        List<Product> products = new ArrayList<>();
        if (categoryOpt.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("category", "Category not found", null));
        } else {
            products = productRepository.findAllByCategory(categoryOpt.get());
        }
        return products;
    }

    private List<Product> findByName(String name, List<FieldErrorDto> fieldErrors) {
        List<Product> products = productRepository.findByNameStartingWithIgnoreCase(name);
        if (products.isEmpty()) {
            fieldErrors.add(new FieldErrorDto("name", "No products found with name starting with '" + name + "'", null));
        }
        return products;
    }
}
