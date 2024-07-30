package org.blb.controller.api.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.blb.DTO.user.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin/user")
public interface UserAPI {
    @Operation(summary = "Getting user list", description = "The operation is available to admin user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description ="Information about users",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Region with ID = .. not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\": \"Region with ID = 25 not found\"}")))

    })

    @GetMapping("/{page}")
    ResponseEntity<List<UserResponseDTO>> getUsers(@PathVariable Integer page);
}
