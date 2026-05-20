package org.example.productsbackend.services;

import org.example.productsbackend.domain.dto.request.CreateSpecimenRequest;
import org.example.productsbackend.domain.dto.request.UpdateSpecimenRequest;
import org.example.productsbackend.domain.dto.response.PageableResponse;
import org.example.productsbackend.domain.dto.response.specimen.SpecimenResponse;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}