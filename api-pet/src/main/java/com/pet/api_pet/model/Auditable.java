package com.pet.api_pet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Auditable {

    private Instant createdAt = Instant.now();

    private UUID createdBy;

    private Instant updatedAt;

    private UUID updatedBy;

    private Instant deletedAt;

    private UUID deletedBy;

    private Boolean active;
}
