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
                            examples = @ExampleObject(value = "{\\n\" +\n" +
                                    "                                    \"    \\\"products\\\": [\\n\" +\n" +
                                    "                                    \"        {\\n\" +\n" +
                                    "                                    \"            \\\"id\\\": 20,\\n\" +\n" +
                                    "                                    \"            \\\"imageUrl\\\": \\\"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\\\",\\n\" +\n" +
                                    "                                    \"            \\\"name\\\": \\\"Verkaufe Tisch\\\",\\n\" +\n" +
                                    "                                    \"            \\\"category\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Books\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"price\\\": 190.0,\\n\" +\n" +
                                    "                                    \"            \\\"description\\\": \\\"A high quality Table for a good time.\\\",\\n\" +\n" +
                                    "                                    \"            \\\"region\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"regionName\\\": \\\"Berlin\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"owner\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"currentUser\\\"\\n\" +\n" +
                                    "                                    \"            }\\n\" +\n" +
                                    "                                    \"        },\\n\" +\n" +
                                    "                                    \"        {\\n\" +\n" +
                                    "                                    \"            \\\"id\\\": 19,\\n\" +\n" +
                                    "                                    \"            \\\"imageUrl\\\": \\\"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\\\",\\n\" +\n" +
                                    "                                    \"            \\\"name\\\": \\\"Verkaufe Tisch\\\",\\n\" +\n" +
                                    "                                    \"            \\\"category\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Electronics\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"price\\\": 180.0,\\n\" +\n" +
                                    "                                    \"            \\\"description\\\": \\\"A high quality Table for a good time.\\\",\\n\" +\n" +
                                    "                                    \"            \\\"region\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"regionName\\\": \\\"Bayern\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"owner\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"currentUser\\\"\\n\" +\n" +
                                    "                                    \"            }\\n\" +\n" +
                                    "                                    \"        },\\n\" +\n" +
                                    "                                    \"        {\\n\" +\n" +
                                    "                                    \"            \\\"id\\\": 18,\\n\" +\n" +
                                    "                                    \"            \\\"imageUrl\\\": \\\"https://ifiwjdganyiodnmwtdlr.supabase.co/storage/v1/object/public/blb_rent/some_link.jpg\\\",\\n\" +\n" +
                                    "                                    \"            \\\"name\\\": \\\"Verkaufe Tisch\\\",\\n\" +\n" +
                                    "                                    \"            \\\"category\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"Others\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"price\\\": 170.0,\\n\" +\n" +
                                    "                                    \"            \\\"description\\\": \\\"A high quality Table for a good time.\\\",\\n\" +\n" +
                                    "                                    \"            \\\"region\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"regionName\\\": \\\"Baden-Württemberg\\\"\\n\" +\n" +
                                    "                                    \"            },\\n\" +\n" +
                                    "                                    \"            \\\"owner\\\": {\\n\" +\n" +
                                    "                                    \"                \\\"name\\\": \\\"currentUser\\\"\\n\" +\n" +
                                    "                                    \"            }\\n\" +\n" +
                                    "                                    \"        }\" +\n" +
                                    "                                    \"],\\n\" +\n" +
                                    "                                    \"    \\\"error\\\": null,\\n\" +\n" +
                                    "                                    \"    \\\"currentPage\\\": 0,\\n\" +\n" +
                                    "                                    \"    \\\"totalPages\\\": 1\\n\" +\n" +
                                    "                                    \"}"))),
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
