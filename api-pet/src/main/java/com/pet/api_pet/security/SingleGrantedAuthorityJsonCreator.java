package com.pet.api_pet.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SingleGrantedAuthorityJsonCreator {
    @JsonCreator
    public SingleGrantedAuthorityJsonCreator(@JsonProperty("authority") String role) {

    }
}
