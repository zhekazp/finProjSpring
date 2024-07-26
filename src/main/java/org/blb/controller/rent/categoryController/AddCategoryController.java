package org.blb.controller.rent.categoryController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.blb.DTO.rent.categoryDto.CategoryCreateRequestDto;
import org.blb.DTO.rent.categoryDto.CategoryResponseDto;
import org.blb.service.rent.categoryService.AddCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rent/categories")
@AllArgsConstructor
public class AddCategoryController {

  private final AddCategoryService addCategoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponseDto> addCategory(@Valid @RequestBody CategoryCreateRequestDto requestDto) {
        CategoryResponseDto responseDto = addCategoryService.addCategory(requestDto.getName());
        return ResponseEntity.ok(responseDto);
    }

}
