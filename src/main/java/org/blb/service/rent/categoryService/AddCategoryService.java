package org.blb.service.rent.categoryService;

import lombok.AllArgsConstructor;
import org.blb.DTO.rent.categoryDto.CategoryResponseDto;
import org.blb.exeption.AlreadyExistException;
import org.blb.models.rent.Category;
import org.blb.repository.rent.CategoryRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class AddCategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponseDto addCategory(String categoryName) {
        Optional<Category> existingCategory = categoryRepository.findByName(categoryName);

        if (existingCategory.isPresent()) {
            throw new AlreadyExistException("Category with name " + categoryName + " already exists.");
        }

        Category newCategory = new Category();
        newCategory.setName(categoryName);
        Category savedCategory = categoryRepository.save(newCategory);

        return new CategoryResponseDto(savedCategory.getId(), savedCategory.getName());
    }
}
