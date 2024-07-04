package com.pet.api_pet.dto;

import com.pet.api_pet.model.DocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private UUID profileId;

    private String profileName;

    private String profileLastName;

    private String profilePhone;

    @Enumerated(EnumType.STRING)
    private DocumentType profileDocumentType;//1: DNI,2:CarnetExtranjeria,3:Pasaporte

    private String profileDocumentNumber;

    private String profileImgDocument;

    private String profileAddress;

    private UUID userId;

    private UserDTO user;

    private Long districtId;
    private DistrictDTO district;

}
