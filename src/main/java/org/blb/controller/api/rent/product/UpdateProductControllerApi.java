package org.blb.controller.api.rent.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.blb.DTO.appDTO.OneMessageDTO;
import org.blb.DTO.rent.productDto.ProductCreateRequestDto;
import org.blb.DTO.rent.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rent")
public interface UpdateProductControllerApi {



    @Operation(summary = "Update a product by ID", description = "Updates an existing product identified by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data or category/user not found"),
            @ApiResponse(responseCode = "404", description = "Product not found with the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<OneMessageDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductCreateRequestDto productCreateRequestDto);
}
