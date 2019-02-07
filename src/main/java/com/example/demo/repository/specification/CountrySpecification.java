package com.example.demo.repository.specification;

import com.example.demo.entity.CountryEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;


public class CountrySpecification {

    private CountrySpecification() {    }

    public static Specification<CountryEntity> getByPopulationAndSurfaceArea(final Integer population, final Integer surfaceArea ) {

        return (root, query, builder) -> {

            final Predicate populationPred = builder.greaterThanOrEqualTo(root.get("population"), population);
            final Predicate surfacePred = builder.greaterThanOrEqualTo(root.get("surfaceArea"), surfaceArea);
            return query.where(builder.and(populationPred, surfacePred)).getGroupRestriction();
        };
    }
}