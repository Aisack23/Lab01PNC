package org.example.productsbackend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.productsbackend.domain.dto.request.CreateSpecimenRequest;
import org.example.productsbackend.domain.dto.request.UpdateSpecimenRequest;
import org.example.productsbackend.domain.dto.response.GeneralResponse;
import org.example.productsbackend.services.impl.SpecimenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/specimen")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenServiceImpl specimenService;

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse> createSpecimen(@Valid @RequestBody CreateSpecimenRequest request) {
        return buildResponse(
                "Specimen registered in Sheikah Slate successfully",
                HttpStatus.CREATED,
                specimenService.createSpecimen(request)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return buildResponse(
                "Specimens retrieved from Sheikah Slate successfully",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder)
        );
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(@PathVariable UUID id) {
        return buildResponse(
                "Specimen found in Sheikah Slate records",
                HttpStatus.OK,
                specimenService.getSpecimenById(id)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateSpecimenRequest request
    ) {
        return buildResponse(
                "Specimen updated in Sheikah Slate successfully",
                HttpStatus.OK,
                specimenService.updateSpecimen(id, request)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecimen(@PathVariable UUID id) {
        return buildResponse(
                "Specimen removed from Sheikah Slate records",
                HttpStatus.OK,
                specimenService.deleteSpecimen(id)
        );
    }

    private ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }
}