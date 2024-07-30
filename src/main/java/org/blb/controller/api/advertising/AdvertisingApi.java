package org.blb.controller.api.advertising;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.blb.DTO.advertisingDto.AdvertisingRequestDto;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.blb.DTO.advertisingDto.ShortAdvertisingResponseDto;
import org.blb.DTO.appDTO.StandardDelRequest;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/advertising")
//@CrossOrigin(origins = "http://localhost:5173")
//public interface AdvertisingApi {
//
//    @Operation(summary = "Adding new advertising", description = "The operation is available to registered users, add new advertising")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertising added",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertising added successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertising not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertising not found\"}")))
//    })
//    @PutMapping
//    ResponseEntity<ShortAdvertisingResponseDto> addAdvertising(@RequestBody @Valid AdvertisingRequestDto dto);
//
//    @Operation(summary = "Deleting advertising", description = "The operation is available to the owner of the advertising or admin")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertising deleting",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertising removed successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertising not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertising not found\"}")))
//    })
//    @DeleteMapping
//    ResponseEntity<StandardResponseDto> deleteAdvertising(@RequestBody @Valid StandardDelRequest dto);
//
//    @Operation(summary = "Updating advertising", description = "The operation is available to the owner of the advertising or admin")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertising updating",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertising updated successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertising not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertising not found\"}")))
//    })
//    @PostMapping
//    ResponseEntity<StandardResponseDto> updateAdvertising(@RequestBody @Valid AdvertisingRequestDto dto);
//
//    @Operation(summary = "Finding advertising by email", description = "The operation is available to all users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertising found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertising found successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertising not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertising not found\"}")))
//    })
//    @GetMapping("/email")
//    ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(@RequestParam String email);
//
//    @Operation(summary = "Finding all advertisements", description = "The operation is available to all users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertisements found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertisements found successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertisements not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertisements not found\"}")))
//    })
//    @GetMapping("/all")
//    ResponseEntity<List<ShortAdvertisingResponseDto>> findAll();
//
//    @Operation(summary = "Finding advertising by ID", description = "The operation is available to all users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertising found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertising found successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertising not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertising not found\"}")))
//    })
//    @GetMapping("/{id}")
//    ResponseEntity<ShortAdvertisingResponseDto> findAdvertisingById(@PathVariable Long id);
//
//    @Operation(summary = "Finding five random advertisements", description = "The operation is available to all users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Information about advertisements found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{ \"message\": \"Advertisements found successfully\"}"))),
//            @ApiResponse(responseCode = "404", description = "Advertisements not found",
//                    content = @Content(mediaType = "application/json",
//                            examples = @ExampleObject(value = "{\"message\": \"Advertisements not found\"}")))
//    })
//    @GetMapping("/random")
//    ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings();
//}