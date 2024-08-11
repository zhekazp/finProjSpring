package org.blb.controller.api.rent.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.blb.DTO.rent.ProductSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rents/my")
public interface AllProductsByUserControllerApi {

    /**
     * Find all products of an authorized user.
     *
     * @return ResponseEntity with the response containing found products or errors.
     */
    @Operation(summary = "Search Products by current-authorized user",
            description = "Operation to search for products of an authorized user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "  \"products\": [\n" +
                                    "    {\n" +
                                    "      \"id\": 20,\n" +
                                    "      \"imageUrl\": \"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\",\n" +
                                    "      \"name\": \"Verkaufe Tisch\",\n" +
                                    "      \"category\": { \"name\": \"Books\" },\n" +
                                    "      \"price\": 190.0,\n" +
                                    "      \"description\": \"A high quality Table for a good time.\",\n" +
                                    "      \"region\": { \"regionName\": \"Berlin\" },\n" +
                                    "      \"owner\": { \"name\": \"currentUser\" }\n" +
                                    "    },\n" +
                                    "    {\n" +
                                    "      \"id\": 19,\n" +
                                    "      \"imageUrl\": \"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\",\n" +
                                    "      \"name\": \"Verkaufe Tisch\",\n" +
                                    "      \"category\": { \"name\": \"Electronics\" },\n" +
                                    "      \"price\": 180.0,\n" +
                                    "      \"description\": \"A high quality Table for a good time.\",\n" +
                                    "      \"region\": { \"regionName\": \"Bayern\" },\n" +
                                    "      \"owner\": { \"name\": \"currentUser\" }\n" +
                                    "    },\n" +
                                    "    {\n" +
                                    "      \"id\": 18,\n" +
                                    "      \"imageUrl\": \"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\",\n" +
                                    "      \"name\": \"Verkaufe Tisch\",\n" +
                                    "      \"category\": { \"name\": \"Others\" },\n" +
                                    "      \"price\": 170.0,\n" +
                                    "      \"description\": \"A high quality Table for a good time.\",\n" +
                                    "      \"region\": { \"regionName\": \"Baden-Württemberg\" },\n" +
                                    "      \"owner\": { \"name\": \"currentUser\" }\n" +
                                    "    }\n" +
                                    "  ],\n" +
                                    "  \"error\": null,\n" +
                                    "  \"currentPage\": 0,\n" +
                                    "  \"totalPages\": 1\n" +
                                    "}"))),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"timestamp\": \"2024-08-03T15:30:44.753+00:00\",\n" +
                                    "    \"status\": 403,\n" +
                                    "    \"error\": \"Forbidden\",\n" +
                                    "    \"path\": \"/api/rents/my\"\n" +
                                    "}"))),
            @ApiResponse(responseCode = "404", description = "No products by current user",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"message\": \"You have not products yet.\"\n" +
                                    "}")))
    })
    @GetMapping
    ResponseEntity<ProductSearchResponse> getUserProducts(
            @RequestParam(defaultValue = "0") int page);
}
