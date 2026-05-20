package org.example.productsbackend.common.mappers;

import org.example.productsbackend.domain.dto.request.CreateSpecimenRequest;
import org.example.productsbackend.domain.dto.request.UpdateSpecimenRequest;
import org.example.productsbackend.domain.dto.response.PageableResponse;
import org.example.productsbackend.domain.dto.response.specimen.SpecimenResponse;
import org.example.productsbackend.domain.entities.Specimen;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class SpecimenMapper {

    public Specimen toEntityCreate(CreateSpecimenRequest request) {
        return Specimen.builder()
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public Specimen toEntityUpdate(UpdateSpecimenRequest request, UUID id) {
        return Specimen.builder()
                .id(id)
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public SpecimenResponse toDto(Specimen specimen) {
        return SpecimenResponse.builder()
                .id(specimen.getId())
                .name(specimen.getName())
                .region(specimen.getRegion())
                .dangerLevel(specimen.getDangerLevel())
                .isFriendly(specimen.getIsFriendly())
                .build();
    }

    public PageableResponse<SpecimenResponse> toPageableResponse(Page<Specimen> page) {
        return PageableResponse.<SpecimenResponse>builder()
                .content(page.map(this::toDto).getContent())
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}