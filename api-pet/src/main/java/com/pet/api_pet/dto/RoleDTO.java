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
public class RoleDTO extends Auditable {

    private UUID roleId;

    private String roleName;
}
