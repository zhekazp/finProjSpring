package org.blb.controller.api.rent.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.blb.DTO.rent.ProductSearchResponse;
import org.blb.DTO.rent.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/rents")

public interface FindProductControllerApi {

    /**
     * Finds products based on the specified criteria.
     *
     * @param region   the name of the region (optional).
     * @param category the name of the category (optional).
     * @param name     the name of the product (optional).
     * @return ResponseEntity with the response containing found products or errors.
     */
    @Operation(summary = "Search Products",
            description = "Operation to search for products by region, category, and name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\\n\" +\n" +
                                    "                                    \"    \\\"products\\\": [\\n\" +\n" +
                                    "                                    \"        {\\n\" +\n" +
                                    "                                    \"            \\\"id\\\": 22,\\n\" +\n" +
                                    "                                    \"            \\\"imageUrl\\\": null,\\n\" +\n" +
                                    "                                    \"            \\\"name\\\": \\\"Table\\\",\\n\" +\n" +
                                    "                                    \"            \\\"category\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Others\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"price\\\": 20.0,\\n\" +\n" +
                                    "                                    \"            \\\"description\\\": \\\"A high quality SUP suitable for a good time.\\\",\\n\" +\n" +
                                    "                                    \"            \\\"region\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"regionName\\\": \\\"Bremen\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"owner\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"jams008\\\"\\n\" +\n" +
                                    "                                    \"            }\\n\" +\n" +
                                    "                                    \"        },\\n\" +\n" +
                                    "                                    \"        {\\n\" +\n" +
                                    "                                    \"           {\\n\" +\n" +
                                    "                                    \"            \\\"id\\\": 1,\\n\" +\n" +
                                    "                                    \"            \\\"imageUrl\\\": \\\"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\\\",\\n\" +\n" +
                                    "                                    \"            \\\"name\\\": \\\"Verkaufe Tisch\\\",\\n\" +\n" +
                                    "                                    \"            \\\"category\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Electronics\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"price\\\": 0.0,\\n\" +\n" +
                                    "                                    \"            \\\"description\\\": null,\\n\" +\n" +
                                    "                                    \"            \\\"region\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"regionName\\\": \\\"Baden-Württemberg\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"owner\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Administrator\\\"\\n\" +\n" +
                                    "                                    \"            }\\n\" +\n" +
                                    "                                    \"        },...\" +\n" +
                                    "                                    \"],\\n\" +\n" +
                                    "                                    \"    \\\"error\\\": null,\\n\" +\n" +
                                    "                                    \"    \\\"currentPage\\\": 0,\\n\" +\n" +
                                    "                                    \"    \\\"totalPages\\\": 3\\n\" +\n" +
                                    "                                    \"}"))),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"products\": [],\n" +
                                    "    \"error\": {\n" +
                                    "        \"message\": \"Errors occurred\",\n" +
                                    "        \"fieldErrors\": [\n" +
                                    "            {\n" +
                                    "                \"field\": \"region\",\n" +
                                    "                \"message\": \"Region not found\"\n" +
                                    "            },\n" +
                                    "            {\n" +
                                    "                \"field\": \"category\",\n" +
                                    "                \"message\": \"Category not found\"\n" +
                                    "            }\n" +
                                    "        ]\n" +
                                    "    },\n" +
                                    "    \"totalElements\": 0,\n" +
                                    "    \"totalPages\": 0\n" +
                                    "}"))),
            @ApiResponse(responseCode = "404", description = "No products found for the given criteria",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"products\": [],\n" +
                                    "    \"error\": {\n" +
                                    "        \"message\": \"Errors occurred\",\n" +
                                    "        \"fieldErrors\": [\n" +
                                    "            {\n" +
                                    "                \"field\": \"products\",\n" +
                                    "                \"message\": \"No products found for the given criteria\"\n" +
                                    "            }\n" +
                                    "        ]\n" +
                                    "    },\n" +
                                    "    \"totalElements\": 0,\n" +
                                    "    \"totalPages\": 0\n" +
                                    "}")))
    })
    @GetMapping
    ResponseEntity<ProductSearchResponse> findProducts(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page);

    /**
     * Finds product by ID.
     *
     * @param id the ID of the product.
     * @return ResponseEntity with the response containing the product or an error message.
     */
    @Operation(summary = "Search product by ID",
            description = "Operation to search for a product by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "     {\n" +
                                    "            \"imageUrl\": \"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/some_bucket/some_link.jpg\",\n" +
                                    "            \"name\": \"SUP\",\n" +
                                    "            \"category\": {\n" +
                                    "                \"name\": \"Vehicles\"\n" +
                                    "            },\n" +
                                    "            \"price\": 30.0,\n" +
                                    "            \"description\": \"A high quality SUP suitable for a good time.\",\n" +
                                    "            \"region\": {\n" +
                                    "                \"regionName\": \"Bremen\"\n" +
                                    "            },\n" +
                                    "            \"owner\": {\n" +
                                    "                \"name\": \"some_owner\"\n" +
                                    "            }\n" +
                                    "        }"))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"message\": \"Product not found with id: ...\"\n" +
                                    "}")))
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id);
}
