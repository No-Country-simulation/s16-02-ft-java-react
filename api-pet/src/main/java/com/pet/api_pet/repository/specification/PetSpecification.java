package com.pet.api_pet.repository.specification;

import com.pet.api_pet.model.Pet;
import org.springframework.data.jpa.domain.Specification;

public class PetSpecification {

    public static Specification<Pet> hasName(String petName){
        return ((root, query, criteriaBuilder) ->
                petName == null ? null : criteriaBuilder.like(root.get("petName"),"%"+petName+"%"));
    }

    public static Specification<Pet> hasSex(String petSex) {
        return (root, query, criteriaBuilder) ->
                petSex == null ? null : criteriaBuilder.equal(root.get("petSex"), petSex);
    }

    public static Specification<Pet> hasBreed(String petBreed) {
        return (root, query, criteriaBuilder) ->
                petBreed == null ? null : criteriaBuilder.equal(root.get("petBreed"), petBreed);
    }

    public static Specification<Pet> hasSize(String petSize) {
        return (root, query, criteriaBuilder) ->
                petSize == null ? null : criteriaBuilder.equal(root.get("petSize"), petSize);
    }

    public static Specification<Pet> hasType(String petType) {
        return (root, query, criteriaBuilder) ->
                petType == null ? null : criteriaBuilder.equal(root.get("petType"), petType);
    }

    public static Specification<Pet> hasAge(Integer minAge, Integer maxAge){
            return (root, query, criteriaBuilder) -> {
                if (minAge == null && maxAge == null) {
                    return null;
                } else if (minAge != null && maxAge != null) {
                    return criteriaBuilder.between(root.get("petAge"), minAge, maxAge);
                } else if (minAge != null) {
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("petAge"), minAge);
                } else {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("petAge"), maxAge);
                }
            };
        }
}
