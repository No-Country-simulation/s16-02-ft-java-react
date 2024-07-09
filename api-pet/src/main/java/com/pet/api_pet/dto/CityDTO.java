package com.pet.api_pet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long cityId;

    private String cityName;

    private Long departmentId;

    private DepartmentDTO department;
}
