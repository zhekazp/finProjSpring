package org.blb.controller.rent.productController;

import lombok.AllArgsConstructor;
import org.blb.DTO.rent.ProductSearchResponse;
import org.blb.service.rent.productServise.FindProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/rents")
public class FindProductController{

    private final FindProductService findProductService;

    @GetMapping
    public ResponseEntity<ProductSearchResponse> findProducts(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name) {
        ProductSearchResponse response = findProductService.findProducts(region, category, name);

        if (response.getError() != null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
