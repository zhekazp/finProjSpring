package org.blb.controller.rent.categoryController;

import lombok.AllArgsConstructor;
import org.blb.service.rent.categoryService.DeleteCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rent/categories/deleteCategory")
@AllArgsConstructor
public class DeleteCategoryController {


    private final DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        deleteCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
