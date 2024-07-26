package org.blb.controller.rent.productController;

import lombok.AllArgsConstructor;
import org.blb.controller.api.rent.product.DeleteProductControllerApi;
import org.blb.service.rent.productServise.DeleteProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/rent")
public class DeleteProductController implements DeleteProductControllerApi {

    private final DeleteProductService deleteProductService;


    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        deleteProductService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
