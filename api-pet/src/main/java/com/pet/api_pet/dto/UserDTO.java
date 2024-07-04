package com.pet.api_pet.dto;

import com.pet.api_pet.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends Auditable {
    private UUID userId;

    private String username;

    private UUID roleId;

    private RoleDTO role;
}
