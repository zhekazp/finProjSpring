package org.blb.controller.api.rent.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.blb.DTO.appDTO.OneMessageDTO;
import org.blb.DTO.rent.categoryDto.CategoryCreateRequestDto;
import org.blb.DTO.rent.productDto.ProductCreateRequestDto;
import org.blb.DTO.validationErrorDto.ValidationErrorsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rent")
public interface AddProductControllerApi {

    @PostMapping
    @Operation(summary = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Product successfully created",
                    content = @Content(schema = @Schema(implementation = OneMessageDTO.class),
                            examples = @ExampleObject(value = "{ \"message\": \"Product successfully created\"}"))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation errors",
                    content = @Content(
                            schema = @Schema(implementation = ValidationErrorsDto.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "errors": [
                                            {
                                                "field": "category",
                                                "rejectedValue": null,
                                                "message": "Category with name ... not found."
                                            },
                                            {
                                                "field": "region",
                                                "rejectedValue": null,
                                                "message": "Region with name ... not found."
                                            }
                                        ]
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    ResponseEntity<?> addNewProduct(@Valid @RequestBody ProductCreateRequestDto request);
}

