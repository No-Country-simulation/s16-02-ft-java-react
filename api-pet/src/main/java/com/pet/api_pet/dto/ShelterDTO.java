package com.pet.api_pet.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDTO {
    
    private UUID shelterId;
    @NotNull
    private String shelterName;
    @NotNull
    private String shelterAuthorization;
    @NotNull
    private String shelterImgAuthorization;
    @NotNull
    private String shelterAddress;

    private UUID userId;



    @NotNull
    private UserDTO user;
    @NotNull
    private DistrictDTO district;
}
