package com.example.demo.repository;

import com.example.demo.entity.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<CountryEntity,String>, JpaSpecificationExecutor<CountryEntity> {

    List<CountryEntity> findAll();

    Page<CountryEntity> findAll(final Pageable pageable);

    Optional<CountryEntity> findByCode(@Param("code") final String code);

    Page<CountryEntity> findAll(final Specification spec, final Pageable pageable);

    @Query(value = "FROM CountryEntity country " +
            " LEFT JOIN FETCH country.cities ",
            countQuery = " select count(country) from CountryEntity country "
    )
    Page<CountryEntity> findAllWithCitiesPageable(final Pageable pageable);

}
