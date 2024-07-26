package org.blb.service.rent.categoryService;

import org.blb.exeption.NotFoundException;
import org.blb.repository.rent.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class DeleteCategoryService {

    private final CategoryRepository categoryRepository;

    public DeleteCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        } else{
            throw new NotFoundException("Category not found with id: " + id);
        }
    }
}
